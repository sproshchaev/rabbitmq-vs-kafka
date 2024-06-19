[![Java](https://img.shields.io/badge/Java-E43222??style=for-the-badge&logo=openjdk&logoColor=FFFFFF)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-FFFFFF??style=for-the-badge&logo=Spring)](https://spring.io/projects/spring-boot/)
[![Kafka](https://img.shields.io/badge/Kafka-000000??style=for-the-badge&logo=apachekafka)](https://kafka.apache.org/)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FFFFFF??style=for-the-badge&logo=rabbitmq)](https://www.rabbitmq.com/)
[![Docker](https://img.shields.io/badge/Docker-0E2B62??style=for-the-badge&logo=Docker&logoColor=FFFFFF)](https://www.docker.com/)
# rabbitmq-vs-kafka
<img src="https://i.postimg.cc/3wNP1LsR/Rabbit-MQ-vs-Kafka.png" alt="rabbitmq-vs-kafka" />

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
│   ├── producer-service/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/
│   │   │   │   └── resources/
│   │   │   └── test/
│   │   ├── build.gradle.kts
│   │   └── README.md
├── rabbitmq/
│   ├── consumer-service/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/
│   │   │   │   │   └── com.prosoft/
│   │   │   │   │       └── RabbitMqConsumerApp
│   │   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   │       └── java/
│   │       └── resources/
│   ├── producer-service/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/
│   │   │   │   │   └── com.prosoft/
│   │   │   │   │       └── RabbitMqProducerApp
│   │   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   │       └── java/
│   │       └── resources/
│   ├── build.gradle.kts
│   └── README.md
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
├── docker-compose.yaml
└── README.md
```

### Docker


1. [Zookeeper](https://zookeeper.apache.org/)  
   Docker image: confluentinc/cp-zookeeper:7.6.1  
   Last pushed: 11.04.2024  
   Docker Hub: https://hub.docker.com/r/confluentinc/cp-zookeeper  
   Info: образ Docker, содержащий Apache Zookeeper, который поставляется вместе с платформой Confluent для работы с Apache Kafka.
  
  
2. [Kafka](https://kafka.apache.org/)  
   Docker image: confluentinc/cp-kafka:7.6.1
   Last pushed: 11.04.2024
   Docker Hub: https://hub.docker.com/r/confluentinc/cp-kafka  
   Info: контейнер Docker, содержащий Apache Kafka, от компании Confluent. Версия образа 7.6.1 соответствует версии 
Apache Kafka, которая включена в этот образ.  


3. [Kafdrop](https://github.com/obsidiandynamics/kafdrop)  
   Docker image: linuxforhealth/kafdrop:4.0.1
   Last pushed: 02.11.2023
   Docker Hub: https://hub.docker.com/r/linuxforhealth/kafdrop  
   Info: веб-интерфейс для управления и мониторинга Apache Kafka, который позволяет взаимодействовать с кластером Kafka.  

  
4. [RabbitMQ](https://www.rabbitmq.com/)  
   Docker image: rabbitmq:3.13.3-management (еще возможно: rabbitmq:management)   
   Last pushed: 06.06.2024
   Docker Hub: https://hub.docker.com/_/rabbitmq  
   Info: образ rabbitmq:management содержит в себе RabbitMQ вместе с его управляющим интерфейсом. Версия management 
   обозначает, что этот образ включает в себя управляющий интерфейс, который доступен на порту 15672.  

  
### Monitoring


1. Веб-интерфейс для мониторинга и управления Apache Kafka (Kafdrop) http://localhost:9000/  

  
2. Веб-интерфейс для управления и мониторинга RabbitMQ (RabbitMQ Management Plugin) http://localhost:15672/ 
  