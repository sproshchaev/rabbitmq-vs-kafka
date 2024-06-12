[![Java](https://img.shields.io/badge/Java-E43222??style=for-the-badge&logo=openjdk&logoColor=FFFFFF)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-FFFFFF??style=for-the-badge&logo=Spring)](https://spring.io/projects/spring-boot/)
[![Kafka](https://img.shields.io/badge/Kafka-000000??style=for-the-badge&logo=apachekafka)](https://kafka.apache.org/)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FFFFFF??style=for-the-badge&logo=rabbitmq)](https://www.rabbitmq.com/)
[![Docker](https://img.shields.io/badge/Docker-0E2B62??style=for-the-badge&logo=Docker&logoColor=FFFFFF)](https://www.docker.com/)
# rabbitmq-vs-kafka
A repository with examples comparing RabbitMQ and Apache Kafka

### Project structure
```
rabbitmq-vs-kafka/
├── kafka/
│   ├── consumer-service/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/
│   │   │   │   │   └── com.prosoft/
│   │   │   │   │       └── KafkaConsumerApp
│   │   │   │   └── resources/
│   │   │   └── test/
│   │   ├── build.gradle.kts
│   │   └── README.md
│   └── producer-service/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   └── resources/
│       │   └── test/
│       ├── build.gradle.kts
│       └── README.md
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
├── docker-compose.yml
└── README.md
```