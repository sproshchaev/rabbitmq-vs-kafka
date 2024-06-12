package com.prosoft;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ: consumer-service
 */
@EnableRabbit
@SpringBootApplication
public class RabbitMqConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumerApp.class, args);
    }

    @RabbitListener(queues = "queue1")
    public void processMyQueueOne(String message) {
        System.out.printf("queue1: received from myQueue : %s %n", new String(message.getBytes()));
    }

    @RabbitListener(queues = "queue2")
    public void processMyQueueTwo(String message) {
        System.out.printf("queue2: received from myQueue : %s %n", new String(message.getBytes()));
    }

}
