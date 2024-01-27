package com.sunrise.admissionservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class StudentClientConfiguration {

    @Bean
    WebClient studentClient()
    {
        return WebClient.builder().
                baseUrl("http://localhost:8081/student")
                .build();
    }
}
