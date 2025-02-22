package org.example.rabbitmq.step1;

// 메시지가 전달이 되었을 때 그거를 RabbitTemplate를 통해서 큐에 전달
// producer의 역할을 담당
//@Component
//@RequiredArgsConstructor
//@Log4j2
//public class Sender {
//    private final RabbitTemplate rabbitTemplate;
//
//    public void send(String message) {
//        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME);
//        log.info("Sent {}",message);
//    }
//}
