package com.example.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String test(@RequestHeader("authorization") String authorization,
                       @RequestHeader HttpHeaders headers) {
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.AUTHORIZATION, authorization);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8095/auth/me", HttpMethod.GET, new HttpEntity(header), String.class);

        return response.getBody();
    }

}
