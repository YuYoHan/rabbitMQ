//package org.example.rabbitmq.step5;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class LogPublish {
//    private final RabbitTemplate rabbitTemplate;
//
//    public void publish(String routingKey, String message) {
//        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, routingKey, message);
//        log.debug("message published {} - {}", routingKey, message);
//    }
//}
