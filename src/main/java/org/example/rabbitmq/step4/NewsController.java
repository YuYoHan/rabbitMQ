package org.example.rabbitmq.step4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class NewsController {
    private final NewsPublisher newsPublisher;

    @MessageMapping("/subscribe")
    public void handleSubscribe(@Header("newsType") String newsType) {
        log.debug("newType {}", newsType);
        String newsMessage = newsPublisher.publish(newsType);
        log.debug("newsMessage {}", newsMessage);
    }
}
