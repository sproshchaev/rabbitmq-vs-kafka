rootProject.name = "rabbitmq-vs-kafka"
include("rabbitmq")
include("kafka")
include("kafka:producer-service")
findProject(":kafka:producer-service")?.name = "producer-service"
include("kafka:consumer-service")
findProject(":kafka:consumer-service")?.name = "consumer-service"
include("rabbitmq:consumer-service")
findProject(":rabbitmq:consumer-service")?.name = "consumer-service"
include("rabbitmq:producer-service")
findProject(":rabbitmq:producer-service")?.name = "producer-service"
