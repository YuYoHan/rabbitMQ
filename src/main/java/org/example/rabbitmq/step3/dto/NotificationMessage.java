package org.example.rabbitmq.step3.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NotificationMessage {
    private String message;
}
