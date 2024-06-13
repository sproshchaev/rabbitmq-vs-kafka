package com.prosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.listener.ConsumerSeekAware;

/**
 * Kafka: consumer-service
 */
@EnableKafka
@SpringBootApplication
public class KafkaConsumerApp implements ConsumerSeekAware {

    public static final String CONSUMER_GROUP_ID = "my-consumer-group";

    public static final String VOWELS_LETTERS_TOPIC = "vowels-letters";
    public static final String CONSONANT_LETTERS_TOPIC = "consonant-letters";

    public static final String PARTITION = "0";
    public static final String INITIAL_OFFSET = "0";

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApp.class, args);
    }

    /***
     * Метод consonantLettersListener() читает данные из топика CONSONANT_LETTERS_TOPIC (согласные буквы)
     * и партиции PARTITION с указанием оффсета INITIAL_OFFSET и выводит в консоль.
     * Для кансамера указан CONSUMER_GROUP_ID.
     * @param data - строка, прочтанная из топика
     */
    @KafkaListener(groupId = CONSUMER_GROUP_ID, topicPartitions = @TopicPartition(
                   topic = CONSONANT_LETTERS_TOPIC, partitionOffsets = {@PartitionOffset(
                   partition = PARTITION,
                   initialOffset = INITIAL_OFFSET)}))
    void consonantLettersListener(String data) {
        toConsole(CONSONANT_LETTERS_TOPIC, data);
    }

    /***
     * Метод vowelsLettersListener() читает данные из топика VOWELS_LETTERS_TOPIC (гласные буквы)
     * и партиции PARTITION с указанием оффсета INITIAL_OFFSET и выводит в консоль.
     * Для кансамера указан CONSUMER_GROUP_ID.
     * @param data - строка, прочтанная из топика
     */
    @KafkaListener(groupId = CONSUMER_GROUP_ID, topicPartitions = @TopicPartition(
                   topic = VOWELS_LETTERS_TOPIC, partitionOffsets = {@PartitionOffset(
                   partition = PARTITION,
                   initialOffset = INITIAL_OFFSET)}))
    void vowelsLettersListener(String data) {
        toConsole(VOWELS_LETTERS_TOPIC, data);
    }

    /**
     * Метод toConsole() выводит в консоль данные, которые были приняты из Kafka.
     *
     * @param topic - топик в Kafka
     * @param ch - строка, принятая из Kafka
     */
    private static synchronized void toConsole(String topic, String ch) {
        String message = String.format("Kafka: from topic \"%s\" was received: %s", topic, ch);
        System.out.println(message);
    }

}
