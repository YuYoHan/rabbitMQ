//package org.example.rabbitmq.step7;
//
//import com.rabbitmq.client.Channel;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class OrderConsumer {
//    private static final int MAX_RETRIES = 3;   // 총 시도 제한 수
//    private int retryCount = 0;           // 재시도 횟수
//
//    @RabbitListener(queues = RabbitMQConfig.ORDER_COMPLETED_QUEUE, containerFactory = "rabbitListenerContainerFactory")
//    public void processOrder(String message, Channel channel, @Header("amqp_deliveryTag")long tag) {
//        try {
//            // 실패 유발
//            if("fail".equalsIgnoreCase(message)) {
//                if(retryCount < MAX_RETRIES) {
//                    log.debug("### Fail & Retry = " + retryCount);
//                    retryCount++;
//                    throw new RuntimeException(message);
//                } else {
//                    log.debug("최대 횟수 추가, DLQ로 이동");
//                    retryCount = 0;
//                    // 파라미터 : deliveryTag, multiple, requeue
//                    // requeue가 true일 경우 메시지를 큐에 다시 넣어 재처리하고 false면 메시지를 DLQ로 이동 또는 삭제
//                    channel.basicNack(tag, false, false);
//                }
//                }
//
//            // 성공했을 경우 채널에 재전송하지 말라고 basicAck를 줘야함
//            // 파라미터   : deliveryTag, multiple
//            // true     : 이전의 모든 메시지 한꺼번에 ACK 처리
//            // false    : 현재 태그의 메시지 하나만 ACK 처리
//            channel.basicAck(tag, false);
//            retryCount = 0;
//        } catch (Exception e) {
//            log.error("error 발생 : " + e.getMessage());
//            try {
//                // 실패시 basicReject 재처리 전송
//                channel.basicReject(tag, true);
//            }catch (IOException ie) {
//                log.error("fail & reject message : " + ie.getMessage());
//            }
//        }
//    }
//}
