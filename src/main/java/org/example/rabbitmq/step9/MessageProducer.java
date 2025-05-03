package org.example.rabbitmq.step9;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {
    private final  StockRepository stockRepository;
    private final RabbitTemplate rabbitTemplate;

    @Transactional
    public void sendMessage(StockEntity stockEntity, String testCase) {
        rabbitTemplate.execute(channel -> {
            try {
                channel.txSelect();     // 트랜잭션 시작
                stockEntity.setProcessed(false);
                stockEntity.setCreatedAt(LocalDateTime.now());
                StockEntity stockEntitySaved = stockRepository.save(stockEntity);

                // 메시지 발행
                rabbitTemplate.convertAndSend("transactionQueue", stockEntitySaved);

                if("fail".equalsIgnoreCase(testCase)) {
                    throw new RuntimeException("트랜잭션 작업중에 에러 발생");
                }

                channel.txCommit();
                log.debug("트랜잭션이 정상적으로 처리됨");
            } catch (Exception e) {
                log.debug("트랜잭션 실패 : " + e.getMessage());
                channel.txRollback();
                throw new RuntimeException("트랜잭션 롤백 완료 ", e);
            } finally {
                if(channel != null) {
                    try {
                        channel.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        });
    }
}
