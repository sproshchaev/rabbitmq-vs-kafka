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

### Monitoring
`1.` Веб-интерфейс для управления и мониторинга RabbitMQ (Management Plugin) http://localhost:15672/  

<img src="https://i.postimg.cc/3wNP1LsR/Rabbit-MQ-vs-Kafka.png" alt="Текст..."/> 


<img src="https://private-user-images.githubusercontent.com/95690553/339277968-802634d6-7f31-45cd-a982-fc21f7f82248.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTgyNjY3NTAsIm5iZiI6MTcxODI2NjQ1MCwicGF0aCI6Ii85NTY5MDU1My8zMzkyNzc5NjgtODAyNjM0ZDYtN2YzMS00NWNkLWE5ODItZmMyMWY3ZjgyMjQ4LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA2MTMlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNjEzVDA4MTQxMFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWYzYjMwNTNhODlkNWM2MTk0ZTlkZWYyNTk5NDhkMmRiNTVlMzYzNzViYjE2ZWMwNTRhODZjOTgxMTIzZTc2ZmYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.UZtmUY9iPkBaqNBpoCE9pkGrCOaz2SKIyyEc5RS45vs" alt="Текст..."/>

### References


`1.` Быстрый старт. SpringBoot + RabbitMQ https://habr.com/ru/articles/782234/  
`2.` RabbitMQ + Spring boot + Docker. Отправляем и получаем сообщения через Producer и Consumer. Пошаговое руководство https://habr.com/ru/articles/703352/   
