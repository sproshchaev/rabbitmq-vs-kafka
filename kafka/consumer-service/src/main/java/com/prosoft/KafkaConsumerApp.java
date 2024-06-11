package com.prosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kafka: consumer-service
 */
@SpringBootApplication
public class KafkaConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApp.class, args);
    }

}
