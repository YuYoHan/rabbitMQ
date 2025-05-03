//package org.example.rabbitmq.step7;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class OrderDLQConsumer  {
//    private final RabbitTemplate rabbitTemplate;
//
//    @RabbitListener(queues = RabbitMQConfig.DLQ)
//    public void process(String message) {
//        log.debug("DLQ Message Received : " + message);
//
//        try {
//            String fixMessage = "success";
//            rabbitTemplate.convertAndSend(
//                    RabbitMQConfig.ORDER_COMPLETED_EXCHANGE,
//                    "order.completed.shipping",
//                    fixMessage
//            );
//            log.debug("DLQ Message Sent : " + fixMessage);
//        } catch (Exception e) {
//            log.debug("DLQ Consumer Error : " + e.getMessage());
//        }
//    }
//}
