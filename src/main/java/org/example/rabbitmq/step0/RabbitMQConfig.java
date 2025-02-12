package org.example.rabbitmq.step0;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {
    // 큐 네임을 설정
    public static final String QUEUE_NAME = "helloQueue";

    @Bean
    public Queue queue() {
        /*
        *   1번 파라미터 : 이름
        *   2번 파리미터 : 서버가 종료되면 메시지를 언제까지 보관할것인지
        *       - false면 휘발성 volatile
        *       - true면 영속성 persistent
        * */
        return new Queue(QUEUE_NAME, false);
    }


    /*
    *   RabbitMQ 연결을 담당
    *   ConnectionFactory : rabbitMQ의 연결을 관리하는 객체
    * */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                    MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    // 메시지를 받아서 특정 객체(Receiver)의 메서드(receiveMessage)를 호출하도록 설정
    @Bean
    public MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
