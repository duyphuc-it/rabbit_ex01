package com.example.publisher;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class BeanConfig {
    @Bean
    public RabbitAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Queue ghtkQueue() {
        Map<String, Object> args= new HashMap<>();
        args.put("x-max-priority", 20);
        return  new Queue("ghtk", false, false, false, args);
    }

    @Bean
    public Queue sapoExpressQueue() {
        Map<String, Object> args= new HashMap<>();
        args.put("x-max-priority", 20);
        return  new Queue("sapo-express", false, false, false, args);
    }

    @Bean
    public DirectExchange orderCreatedExchange() {
        return new DirectExchange("OrderCreatedExchange");
    }

    @Bean
    public Binding ghtkBinding(@Qualifier("ghtkQueue") Queue queue, @Qualifier("orderCreatedExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("ghtk");
    }

    @Bean
    public Binding sapoExpressBinding(@Qualifier("sapoExpressQueue") Queue queue, @Qualifier("orderCreatedExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("sapo-express");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
