package com.prosoft;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ: producer-service
 */
@SpringBootApplication
public class RabbitMqProducerApp implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqProducerApp(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProducerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        rabbitTemplate.convertAndSend("myExchange", "routingKeyQueue1", "qwerty");
        rabbitTemplate.convertAndSend("myExchange", "routingKeyQueue1", "QWERTY");
    }

}
