package com.example.publisher;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderModel orderRequest) {
        if(Arrays.asList(DeliveryServiceProvider.GHTK, DeliveryServiceProvider.SAPO_EXPRESS).contains(orderRequest.getDeliveryServiceProvider())) {
            rabbitTemplate.convertAndSend("OrderCreatedExchange", orderRequest.deliveryServiceProvider, orderRequest,  message -> {
                message.getMessageProperties().setPriority(orderRequest.getPrioritized().equals(true) ? 1 : 0);
                return message;
            });
            return "publish success";
        } else {
            return "delivery provider service not exits";
        }
    }
}
