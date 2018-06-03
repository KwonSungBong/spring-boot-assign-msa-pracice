package com.example.demo.controller.api;

import com.example.demo.domain.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class UserController {

//    @GetMapping("/me")
//    public Principal me(Principal user) {
//        return user;
//    }

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public UserDto.Refer me(Principal user) {
        return userService.findByUsername(user.getName());
    }

}
