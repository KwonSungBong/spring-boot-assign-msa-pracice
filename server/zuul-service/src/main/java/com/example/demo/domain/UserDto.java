package com.example.demo.domain;

import lombok.Data;

public class UserDto {

    @Data
    public static class Refer {
        private Long id;
        private String email;
        private String name;
    }

}
