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

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApp.class, args);
    }

    @Override
    public void run(String... args) {

        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";

        for (char c : vowels.toCharArray()) {
            kafkaTemplate.send("vowels-letters", "vowels", String.valueOf(c));
        }

        for (char c : consonants.toCharArray()) {
            kafkaTemplate.send("consonant-letters", "consonants", String.valueOf(c));
        }
    }
}
