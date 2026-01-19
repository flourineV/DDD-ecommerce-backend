package com.ecommerce.ucp.context;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class ContextManager {

    private final Map<String, Object> contextStore = new ConcurrentHashMap<>();

    public void saveContext(String sessionId, String key, Object value) {
        log.info("Saving context for session: {}, key: {}", sessionId, key);
        String contextKey = sessionId + ":" + key;
        contextStore.put(contextKey, value);
    }

    public Object getContext(String sessionId, String key) {
        log.info("Retrieving context for session: {}, key: {}", sessionId, key);
        String contextKey = sessionId + ":" + key;
        return contextStore.get(contextKey);
    }

    public void clearContext(String sessionId) {
        log.info("Clearing context for session: {}", sessionId);
        contextStore.keySet().removeIf(key -> key.startsWith(sessionId + ":"));
    }
}
