package org.example.rabbitmq.step9;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageConsumer {
    private final StockRepository stockRepository;

    @RabbitListener(queues = "transactionQueue")
    public void receiveTransaction(StockEntity stockEntity) {
        log.debug("# received message : " + stockEntity);
        try {
            stockEntity.setProcessed(true);
            stockEntity.setUpdatedAt(LocalDateTime.now());
            stockRepository.save(stockEntity);  // 상태 업데이트
            log.debug("# stockEntity 저장 완료");
        } catch (Exception e) {
            log.debug("# Entity 수정 에러 : " + e.getMessage());
            throw e;
        }
    }
}
