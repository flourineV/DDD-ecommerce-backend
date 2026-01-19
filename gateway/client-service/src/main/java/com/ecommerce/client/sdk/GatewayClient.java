package com.ecommerce.client.sdk;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class GatewayClient {

    private final WebClient.Builder webClientBuilder;

    public <T> Mono<T> get(String path, Class<T> responseType) {
        log.info("GET request to: {}", path);
        return webClientBuilder.build()
                .get()
                .uri(path)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T, R> Mono<R> post(String path, T body, Class<R> responseType) {
        log.info("POST request to: {}", path);
        return webClientBuilder.build()
                .post()
                .uri(path)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(responseType);
    }
}
