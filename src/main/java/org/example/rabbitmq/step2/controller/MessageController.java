package org.example.rabbitmq.step2;

import lombok.RequiredArgsConstructor;
import org.example.rabbitmq.step2.WorkQueueProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageController {
    private final WorkQueueProducer workQueueProducer;

    @PostMapping("/workqueue")
    public String sendMessage(@RequestParam String message, @RequestParam int duration) {
        workQueueProducer.sendWorkQueue(message, duration);
        return "Work queue sent : " + message + ", (" + duration + ")";
    }
}
