package org.example.rabbitmq.step2;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.rabbitmq.step2.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class WorkQueueProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendWorkQueue(String workQueueMessage, int duration) {
        String message = workQueueMessage + "|" + duration;
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        log.info("Sent workqueue {}" , message);
    }
}
