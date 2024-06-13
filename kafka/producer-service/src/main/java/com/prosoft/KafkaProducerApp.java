package com.prosoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Kafka: producer-service
 */
@SpringBootApplication
public class KafkaProducerApp implements CommandLineRunner {

    public static final String VOWELS_LETTERS_TOPIC = "vowels-letters";
    public static final String CONSONANT_LETTERS_TOPIC = "consonant-letters";

    public static final String VOWELS_KEY = "vowels";
    public static final String CONSONANTS_KEY = "consonants";

    public static final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String VOWELS = "AEIOU";

    /**
     * Внедрение KafkaTemplate - компонент в Spring для упрощенной работы с Kafka, обеспечивающий удобный способ
     * отправки сообщений в Kafka и ожидания ответов
     */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApp.class, args);
    }

    /**
     * Метод run отправляет сообщения в топик с указанием ключа
     * @param args - аргументы строки вызова
     */
    @Override
    public void run(String... args) {
        for (char ch : ENGLISH_ALPHABET.toCharArray()) {
            if (VOWELS.contains(String.valueOf(ch))) {
                kafkaTemplate.send(VOWELS_LETTERS_TOPIC, VOWELS_KEY, String.valueOf(ch));
                toConsole(VOWELS_LETTERS_TOPIC, VOWELS_KEY, ch);
            } else {
                kafkaTemplate.send(CONSONANT_LETTERS_TOPIC, CONSONANTS_KEY, String.valueOf(ch));
                toConsole(CONSONANT_LETTERS_TOPIC, CONSONANTS_KEY, ch);
            }
        }
    }

    /**
     * Метод toConsole() выводит в консоль данные, которые были отправлены в Kafka.
     *
     * @param topic - имя топика
     * @param key - имя ключа
     * @param ch - символьная переменная
     */
    private static synchronized void toConsole(String topic, String key, char ch) {
        String message = String.format("Kafka: to topic \"%s\" with key \"%s\" sent: %c", topic, key, ch);
        System.out.println(message);
    }

}
