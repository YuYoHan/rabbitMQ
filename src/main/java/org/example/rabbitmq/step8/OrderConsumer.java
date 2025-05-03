package org.example.rabbitmq.step8;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class OrderConsumer {
    private int retryCount;

    @RabbitListener(queues = RabbitMQConfig.ORDER_COMPLETED_QUEUE)
    public void processMessage(String message) {
        log.debug("Received message : " + message + ", count : " + retryCount++);
        if("fail".equalsIgnoreCase(message)) {
            throw new RuntimeException("- Processing failed. Retry");
        }
        log.debug("Message processed successfully : " + message);
    }
}
