package com.example.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class PublisherApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

	@Override
	public void run(String... args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		System.out.println("----------------------------------------");
		System.out.println("APPLICATION STARTED");
	}
}
