package com.prosoft.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {

    public static final String EXCHANGE_NAME = "myExchange";
    public static final String ROUTING_KEY_QUEUE1 = "routingKeyQueue1";
    public static final String ROUTING_KEY_QUEUE2 = "routingKeyQueue2";
    public static final String QUEUE1 = "queue1";
    public static final String QUEUE2 = "queue2";

    @Value("${spring.rabbitmq.username}")
    private String rabbitUsername;

    @Value("${spring.rabbitmq.password}")
    private String rabbitPassword;

    @Value("${spring.rabbitmq.virtual-host}")
    private String rabbitVirtualHost;

    /**
     * Бин connectionFactory служит для настройки соединения с сервером RabbitMQ.
     * Бин предоставляет параметры для установления связи: хост, имя пользователя, пароль, виртуальный хост.
     * Использование CachingConnectionFactory добавляет функциональность кэширования соединений для повышения производительности.
     *
     * @return Bean ConnectionFactory
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername(rabbitUsername);
        cachingConnectionFactory.setPassword(rabbitPassword);
        cachingConnectionFactory.setVirtualHost(rabbitVirtualHost);
        return cachingConnectionFactory;
    }

    /**
     * Бин amqpAdmin используется для административных операций с RabbitMQ: создание, удаление, проверка существования очередей,
     * обменников (exchange) и привязок (binding). Бин автоматически объявляет все объекты типа Queue, Exchange и Binding,
     * которые находятся в контексте приложения
     *
     * @return Bean AmqpAdmin
     */
    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    /**
     * Бин rabbitTemplate предоставляет высокоуровневый API для взаимодействия с RabbitMQ.
     * Это основной шаблон, который используется для отправки и получения сообщений.
     *
     * @return Bean RabbitTemplate
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    /**
     * Бин directExchange создает обменник (exchange) типа "direct" в RabbitMQ с именем EXCHANGE_NAME,
     * который используется для создания прямого обменника в RabbitMQ, который маршрутизирует сообщения
     * в очереди на основе точных совпадений ключей маршрутизации.
     * Параметр durable (устойчивость) = true - обменник сохранится даже после перезагрузки RabbitMQ.
     * Параметр autoDelete (автоудаление) = false - обменник не будет автоматически удален, когда не будет очередей,
     * связанных с ним.
     *
     * @return Bean DirectExchange
     */
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME, true, false);
    }

    /**
     * Бин myQueueOne используется для создания очереди в RabbitMQ с именем QUEUE1.
     *
     * @return Bean Queue
     */
    @Bean
    public Queue myQueueOne() {
        return new Queue(QUEUE1);
    }

    /**
     * Бин myQueueTwo используется для создания очереди в RabbitMQ с именем QUEUE2.
     *
     * @return Bean Queue
     */
    @Bean
    public Queue myQueueTwo() {
        return new Queue(QUEUE2);
    }

    /**
     * Бин bindingQueueOne создается для привязки очереди "queue1" к обменнику "myExchange" с использованием ключа маршрутизации,
     * что позволяет сообщениям, отправляемым в обменник с этим ключом маршрутизации, быть доставленными в указанную очередь.
     *
     * @param myQueueOne - бин для создания очереди QUEUE1
     * @param directExchange - бин обменник (exchange) типа "direct"
     * @return Bean Binding
     */
    @Bean
    Binding bindingOne(Queue myQueueOne, DirectExchange directExchange) {
        return BindingBuilder.bind(myQueueOne).to(directExchange).with(ROUTING_KEY_QUEUE1);
    }

    /**
     * Бин bindingQueueOne создается для привязки очереди QUEUE2 к обменнику "myExchange" с использованием ключа маршрутизации,
     * что позволяет сообщениям, отправляемым в обменник с этим ключом маршрутизации, быть доставленными в указанную очередь.
     *
     * @param myQueueTwo - бин для создания очереди QUEUE2
     * @param directExchange - бин обменник (exchange) типа "direct"
     * @return Bean Binding
     */
    @Bean
    Binding bindingTwo(Queue myQueueTwo, DirectExchange directExchange) {
        return BindingBuilder.bind(myQueueTwo).to(directExchange).with(ROUTING_KEY_QUEUE2);
    }

}
