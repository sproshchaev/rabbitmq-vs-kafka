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

    public static final String EXCHANGE_NAME = "myExchange";

    public static final String ROUTING_KEY_QUEUE_1 = "routingKeyQueue1";
    public static final String ROUTING_KEY_QUEUE_2 = "routingKeyQueue2";

    public static final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String VOWELS = "AEIOU";

    /**
     * Класс в Spring для взаимодействия с брокером сообщений RabbitMQ, предоставляющий методы отправки и получения
     * сообщений из очередей и обменников
     */
    private final RabbitTemplate rabbitTemplate;

    /**
     * Конструктор RabbitMqProducerApp внедряет зависимость RabbitTemplate
     * @param rabbitTemplate
     */
    @Autowired
    public RabbitMqProducerApp(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProducerApp.class, args);
    }

    /**
     * Метод производит отправку букв английского алфавита в очереди:
     * - гласные буквы отправляются в "queue1" (исп. ROUTING_KEY_QUEUE_1)
     * - согласные буквы отправляются в "queue2" (исп. ROUTING_KEY_QUEUE_2)
     *
     * @param args - аргументы вызова
     * @throws Exception - возможное исключение
     */
    @Override
    public void run(String... args) throws Exception {

        for (char ch : ENGLISH_ALPHABET.toCharArray()) {
            if (VOWELS.contains(String.valueOf(ch))) {
                rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_QUEUE_1, new byte[]{(byte) ch});
                toConsole(ROUTING_KEY_QUEUE_1, ch);
            } else {
                rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_QUEUE_2, new byte[]{(byte) ch});
                toConsole(ROUTING_KEY_QUEUE_2, ch);
            }
        }

    }

    /**
     * Метод toConsole() выводит в консоль данные, которые были отправлены в RabbitMQ.
     *
     * @param routingKey   - имя ключа
     * @param ch           - символьная переменная
     */
    private static void toConsole(String routingKey, char ch) {
        String message = String.format("RabbitMQ: to exchange \"%s\" with key \"%s\" sent: %c", EXCHANGE_NAME, routingKey, ch);
        System.out.println(message);
    }

}
