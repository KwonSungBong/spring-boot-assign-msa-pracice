package com.example.demo.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class UserController {

    @GetMapping("/me")
    public Principal me(Principal user) {
        return user;
    }

}
