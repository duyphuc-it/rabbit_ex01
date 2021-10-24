package com.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Consumer {

    @RabbitListener(concurrency = "10", queues = "ghtk")
    public void listenGhtk(OrderModel model) throws Exception {
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(20) + 1;
        if (number % 20 == 0) {
            throw new Exception("Ghtk error");
        }
        System.out.println("ghtk");
        System.out.println(model.toString());
    }

    @RabbitListener(concurrency = "20", queues = "sapo-express")
    public void listenSapoExpress(OrderModel model) throws Exception {
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(20) + 1;
        if (number % 20 == 0) {
            throw new Exception("Sapo express error");
        }
        System.out.println("Sapo express");
        System.out.println(model.toString());
    }
}
