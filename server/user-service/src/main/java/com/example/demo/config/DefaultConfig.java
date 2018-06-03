package com.example.demo.config;

import com.example.demo.client.AuthClient;
import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DefaultConfig {

//    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AuthClient authClient() {
        AuthClient authClient = Feign.builder().target(AuthClient.class,  "http://localhost:8095");
        return authClient;
    }

}
