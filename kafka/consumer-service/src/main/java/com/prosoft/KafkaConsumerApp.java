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

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApp.class, args);
    }

    /***
     * Метод consonantLettersListener() читает данные из топика "consonant-letters" (согласные буквы) и партиции 0
     * @param data
     */
    @KafkaListener(groupId = "", topicPartitions = @TopicPartition(topic = "consonant-letters",
            partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")}))
    void consonantLettersListener(String data) {
        System.out.println("Received message topic = \"consonant-letters\":" + data);
    }

    /**
     * Метод vowelsLettersListener() читает данные из топика "vowels-letters" (гласные буквы) и партиции 0
     *
     * @param data
     */
    @KafkaListener(groupId = "", topicPartitions = @TopicPartition(topic = "vowels-letters",
            partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")}))
    void vowelsLettersListener(String data) {
        System.out.println("Received message topic = \"vowels-letters\":" + data);
    }

}
