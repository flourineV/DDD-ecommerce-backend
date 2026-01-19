package com.ecommerce.signalr.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationHandler {

    private final SimpMessagingTemplate messagingTemplate;

    public void sendToUser(String userId, String message) {
        log.info("Sending notification to user: {}", userId);
        messagingTemplate.convertAndSendToUser(userId, "/queue/notifications", message);
    }

    public void broadcast(String message) {
        log.info("Broadcasting notification");
        messagingTemplate.convertAndSend("/topic/notifications", message);
    }
}
