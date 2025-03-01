//package org.example.rabbitmq.step3.config;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class NotificationPublisher {
//    private final RabbitTemplate rabbitTemplate;
//
//    public void publish(String message) {
//        // Fanout에서 routing key는 무시됨
//        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, "", message);
//        log.debug("[#] Published Notification: " + message);
//    }
//}
