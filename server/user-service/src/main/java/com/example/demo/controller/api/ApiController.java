package com.example.demo.controller.api;

import com.example.demo.client.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ApiController {

    @Autowired
    private AuthClient authClient;

    @GetMapping
    public String me(@RequestHeader("authorization") String authorization) {
        return authClient.me(authorization);
    }
}
