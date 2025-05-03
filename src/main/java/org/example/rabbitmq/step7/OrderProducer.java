//package org.example.rabbitmq.step7;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class OrderProducer {
//    private final RabbitTemplate rabbitTemplate;
//
//    public void send(String message) {
//        rabbitTemplate.convertAndSend(
//                RabbitMQConfig.ORDER_COMPLETED_EXCHANGE,
//                "order.completed.shipping",
//                message);
//        log.debug("[주문 완료. 배송 지시 메시지 생성 : " + message + "]");
//    }
//}
