package org.example.rabbitmq.step5;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class LogController {
    private final CustomExceptionHandler exceptionHandler;

    @GetMapping("/error")
    public ResponseEntity<String> errorAPI() {
        try {
            String value = null;
            value.getBytes();
        } catch (Exception e) {
            exceptionHandler.handleException(e);
        }
        return ResponseEntity.ok("Controller NullPointer Exception");
    }

    @GetMapping("/warn")
    public ResponseEntity<String> warnAPI() {
        try {
            throw new IllegalArgumentException("invalid argument입니다.");
        } catch (Exception e) {
            exceptionHandler.handleException(e);
        }
        return ResponseEntity.ok("Controller IllegalArgument Exception");
    }

    @PostMapping("/info")
    public ResponseEntity<String> infoAPI(@RequestBody String message) {
        exceptionHandler.handleMessage(message);
        return ResponseEntity.ok("Controller Info Log 발송 처리 : " + message);
    }
}
