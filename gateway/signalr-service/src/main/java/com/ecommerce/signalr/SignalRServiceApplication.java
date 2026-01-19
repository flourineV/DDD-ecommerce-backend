package com.ecommerce.signalr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class SignalRServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SignalRServiceApplication.class, args);
    }
}
