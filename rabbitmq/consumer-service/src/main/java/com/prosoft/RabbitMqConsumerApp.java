package com.prosoft;

import com.prosoft.config.RabbitMqConfig;
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

    /**
     * Метод readMyQueueOne читает данные из очереди QUEUE_1
     * @param message - строка, принятая из RabbitMQ
     */
    @RabbitListener(queues = RabbitMqConfig.QUEUE1)
    public void readMyQueueOne(String message) {
        toConsole(RabbitMqConfig.QUEUE1, new String(message.getBytes()));
    }

    /**
     * Метод readMyQueueTwo читает данные из очереди QUEUE_2
     * @param message - строка, принятая из RabbitMQ
     */
    @RabbitListener(queues = RabbitMqConfig.QUEUE2)
    public void readMyQueueTwo(String message) {
        toConsole(RabbitMqConfig.QUEUE2, new String(message.getBytes()));
    }

    /**
     * Метод toConsole() выводит в консоль данные, которые были приняты из RabbitMQ.
     *
     * @param queues - имя очереди RabbitMQ
     * @param ch - строка, принятая из RabbitMQ
     */
    private static synchronized void toConsole(String queues, String ch) {
        String message = String.format("RabbitMQ: %s was received: %s", queues, ch);
        System.out.println(message);
    }

}
