package com.prosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ: producer-service
 */
@SpringBootApplication
public class RabbitMqProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProducerApp.class, args);
    }

}
