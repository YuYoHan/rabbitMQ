package org.example.rabbitmq.step5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogConsumer {

    @RabbitListener(queues = RabbitMQConfig.ERROR_QUEUE)
    public void consumeError(String message) {
        log.debug("error message {}", message);
    }
    @RabbitListener(queues = RabbitMQConfig.WARN_QUEUE)
    public void consumeWarn(String message) {
        log.debug("warn message {}", message);
    }
    @RabbitListener(queues = RabbitMQConfig.INFO_QUEUE)
    public void consumeInfo(String message) {
        log.debug("info message {}", message);
    }
    @RabbitListener(queues = RabbitMQConfig.ALL_LOG_QUEUE)
    public void consumeAllLog(String message) {
        log.debug("All Log message {}", message);
    }
}
