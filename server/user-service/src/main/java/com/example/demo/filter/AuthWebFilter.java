package com.example.demo.filter;

import com.example.demo.client.AuthClient;
import com.example.demo.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthWebFilter implements WebFilter {

    private User authUser;

    @Autowired
    private AuthClient authClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange,
                             WebFilterChain webFilterChain) {
        String authorization = serverWebExchange.getRequest().getHeaders().getFirst("authorization");

        try {
            String json = authClient.me(authorization);
            authUser = objectMapper.readValue(json, User.class);
        } catch (Exception e) {
            authUser = null;
        }

        return webFilterChain.filter(serverWebExchange);
    }

    public User getAuthUser() {
        return authUser;
    }
}
