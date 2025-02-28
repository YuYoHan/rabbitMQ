package org.example.rabbitmq.step4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NewsPublisher {
    private final RabbitTemplate rabbitTemplate;

    private String publishMessage(String news, String messageSuffix) {
        String message = news + messageSuffix;
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE_FOR_NEWS, news, message);
        log.debug("news published {}", message);
        return message;
    }

    public String publish(String news) {
        return publishMessage(news, " 관련 새 소식이 있어요!");
    }

    public String publishAPI(String news) {
        return publishMessage(news, " - 관련 새 소식이 나왔습니다. (API)");
    }
}
