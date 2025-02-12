package org.example.rabbitmq.step1;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class WorkQueueConsumer {
    public void workQueueTask(String message) {
        String[] messageParts = message.split("\\|");
        String originMessage = messageParts[0];
        int duration = Integer.parseInt(messageParts[1].trim());

        log.info("Received {} duration {} ws", originMessage, duration);

        try {
            log.info("now...sleep time {} ms", duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("Competed {}", originMessage);
    }
}
