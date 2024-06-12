package com.prosoft.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        cachingConnectionFactory.setVirtualHost("/");
        return cachingConnectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("myExchange", true, false);
    }

    @Bean
    public Queue myQueueOne() {
        return new Queue("queue1");
    }

    @Bean
    public Queue myQueueTwo() {
        return new Queue("queue2");
    }
    @Bean
    Binding bindingQueueOne(Queue myQueueOne, DirectExchange exchange) {
        return BindingBuilder.bind(myQueueOne).to(exchange).with("routingKeyQueue1");
    }

    @Bean
    Binding bindingQueueTwo(Queue myQueueTwo, DirectExchange exchange) {
        return BindingBuilder.bind(myQueueTwo).to(exchange).with("routingKeyQueue2");
    }

}
