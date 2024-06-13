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

### RabbitMQ Management Plugin
`1.` Веб-интерфейс для управления и мониторинга (RabbitMQ Management Plugin) http://localhost:15672/  

  
  
### References


`1.` Быстрый старт. SpringBoot + RabbitMQ https://habr.com/ru/articles/782234/  
`2.` RabbitMQ + Spring boot + Docker. Отправляем и получаем сообщения через Producer и Consumer. Пошаговое руководство https://habr.com/ru/articles/703352/   
`3.` Установка, настройка и использование RabbitMQ https://timeweb.cloud/tutorials/microservices/ustanovka-i-nastroika-rabbitmq  
