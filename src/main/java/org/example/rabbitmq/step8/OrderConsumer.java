package org.example.rabbitmq.step8;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class OrderConsumer {
    private final RabbitTemplate rabbitTemplate;
    private final RetryTemplate retryTemplate;

    @RabbitListener(queues = RabbitMQConfig.ORDER_COMPLETED_QUEUE)
    public void consume(String message) {
        retryTemplate.execute(context -> {
            try {
                log.debug("리시브 메시지 : " + message + " [#] retry : " + context.getRetryCount());

                // 실패 조건
                if("fail".equalsIgnoreCase(message)) {
                    throw new RuntimeException(message);
                }
                log.debug("[#] 메시지 처리 성공 : " + message);
            } catch (Exception e) {
                if(context.getRetryCount() >= 2) {
                    rabbitTemplate.convertAndSend(RabbitMQConfig.ORDER_TOPIC_DLX,
                            RabbitMQConfig.DEAD_LETTER_ROUTING_KEY, message);
                } else {
                    throw e;
                }
            }
            return null;
        });
    }
}
