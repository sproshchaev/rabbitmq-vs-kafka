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
Название образа: confluentinc/cp-zookeeper:7.6.0  
Docker Hub: https://hub.docker.com/r/confluentinc/cp-zookeeper  
Описание: образ Docker, содержащий Apache Zookeeper, который поставляется вместе с платформой Confluent для работы с Apache Kafka. 
Версия образа 7.6.0 соответствует версии Confluent Platform, которая включает в себя Apache Zookeeper версии 3.6.2.  

  
2. [Kafka](https://kafka.apache.org/)  
Название образа: confluentinc/cp-kafka:7.6.0  
Docker Hub: https://hub.docker.com/r/confluentinc/cp-kafka  
Описание: контейнер Docker, содержащий Apache Kafka, от компании Confluent. Версия образа 7.6.0 соответствует версии 
Apache Kafka, которая включена в этот образ.  


3. [Kafdrop](https://github.com/obsidiandynamics/kafdrop)  
Название образа: linuxforhealth/kafdrop:latest
Docker Hub: https://hub.docker.com/r/linuxforhealth/kafdrop  
Описание: веб-интерфейс для управления и мониторинга Apache Kafka, который позволяет взаимодействовать с кластером Kafka.  

  
4. [RabbitMQ](https://www.rabbitmq.com/)  
Название образа: rabbitmq:3-management  
Docker Hub: https://hub.docker.com/r/freezippo/rabbitmq-3-management  
Описание: образ rabbitmq:3-management содержит в себе RabbitMQ вместе с его управляющим интерфейсом. 
Версия 3-management обозначает, что этот образ включает в себя управляющий интерфейс, который доступен на порту 15672.  

  
### Monitoring


1. Веб-интерфейс для мониторинга и управления Apache Kafka (Kafdrop) http://localhost:9000/  

  
2. Веб-интерфейс для управления и мониторинга RabbitMQ (Management Plugin) http://localhost:15672/ 
  