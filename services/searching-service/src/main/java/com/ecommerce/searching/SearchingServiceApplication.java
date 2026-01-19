package com.ecommerce.searching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.ecommerce.searching", "com.ecommerce.common" })
public class SearchingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchingServiceApplication.class, args);
    }
}
