//package org.example.rabbitmq.step3.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.example.rabbitmq.step3.dto.NotificationMessage;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//@Controller
//@RequiredArgsConstructor
//@Slf4j
//public class StompController {
//    private final SimpMessagingTemplate messagingTemplate;
//
//    @MessageMapping("/send")
//    public void sendMessage(NotificationMessage message) {
//        // 수신된 메시지를 브로드캐스팅
//        String msg = message.getMessage();
//        log.debug("[#] message = " + msg);
//        // 클라이언트에 메시지 브로드캐스트
//        messagingTemplate.convertAndSend("/topic/notifications", msg);
//    }
//}
