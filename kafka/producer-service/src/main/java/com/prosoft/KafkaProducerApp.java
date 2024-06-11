package com.prosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kafka: producer-service
 */
@SpringBootApplication
public class KafkaProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApp.class, args);
    }

}
