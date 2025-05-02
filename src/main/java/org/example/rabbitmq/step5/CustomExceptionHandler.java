//package org.example.rabbitmq.step5;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class CustomExceptionHandler {
//    private final LogPublish logPublish;
//
//    // 에러나 로그 처리
//    public void  handleException(Exception e) {
//        String message = e.getMessage();
//        String routingKey;
//
//        if(e instanceof NullPointerException) {
//            routingKey = "log.error";
//        } else if (e instanceof IllegalArgumentException) {
//            routingKey = "log.warn";
//        }else  {
//            routingKey = "logerror";
//        }
//        logPublish.publish(routingKey, "Exception이 발생 : " + message);
//    }
//
//    // 메시지 처리
//    public void handleMessage(String message) {
//        String routingKey = "log.info";
//        logPublish.publish(routingKey, "Info Log :" + message);
//    }
//}
