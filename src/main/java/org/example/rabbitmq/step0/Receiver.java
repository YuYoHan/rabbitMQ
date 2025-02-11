package org.example.rabbitmq.step0;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

// consumer의 역할을 감당
@Component
@Log4j2
public class Receiver {
    public void receiverMessage(String message) {
        log.info("# Received {}" , message);
    }
}
