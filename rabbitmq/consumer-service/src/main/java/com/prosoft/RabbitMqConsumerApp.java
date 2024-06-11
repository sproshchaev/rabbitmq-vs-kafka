package com.prosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ: consumer-service
 */
@SpringBootApplication
public class RabbitMqConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumerApp.class, args);
    }

}
