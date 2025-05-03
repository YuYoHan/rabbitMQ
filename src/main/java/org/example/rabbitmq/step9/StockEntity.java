package org.example.rabbitmq.step9;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class StockEntity {
    @Id @GeneratedValue
    private Long id;
    private String userId;
    private  int stock;
    private boolean processed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
