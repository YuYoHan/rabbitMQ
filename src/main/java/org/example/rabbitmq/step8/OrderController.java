package org.example.rabbitmq.step8;

import lombok.RequiredArgsConstructor;
import org.example.rabbitmq.step7.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderProducer orderProducer;

    @GetMapping
    public ResponseEntity<?> sendOrderMessage(@RequestParam String message) {
        orderProducer.send(message);
        return ResponseEntity.ok("Order Completed Message send : " + message);
    }
}
