package org.example.rabbitmq.step3.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationSubscriber {
    public static final String CLIENT_URL = "/topic/notifications";
    // websocket으로 메시지를 전달하기 위한 Spring의 템플릿 클래스
    private final SimpMessagingTemplate simpMessagingTemplate;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void subscriber(String message) {
        log.debug("Received Notification: " + message);
        // convertAndSend를 통해 특정 경로로 메시지를 전달함
        simpMessagingTemplate.convertAndSend(CLIENT_URL, message); // 클라이언트에 브로드캐스트
    }
}
