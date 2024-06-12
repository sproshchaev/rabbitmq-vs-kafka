package com.prosoft;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * RabbitMQ: producer-service
 */
@SpringBootApplication
public class RabbitMqProducerApp implements CommandLineRunner {

    public static final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String VOWELS = "AEIOU";

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqProducerApp(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProducerApp.class, args);
    }

    /**
     * Метод производит отправку букв английского алфавита в очереди:
     * - гласные в queue1 (исп. "routingKeyQueue1")
     * - согласные в queue2 (исп. "routingKeyQueue2")
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        for (char ch : ENGLISH_ALPHABET.toCharArray()) {
            if (VOWELS.contains(String.valueOf(ch))) {
                rabbitTemplate.convertAndSend("myExchange", "routingKeyQueue1", new byte[]{(byte) ch});
            } else {
                rabbitTemplate.convertAndSend("myExchange", "routingKeyQueue2", new byte[]{(byte) ch});
            }
        }
    }

}
