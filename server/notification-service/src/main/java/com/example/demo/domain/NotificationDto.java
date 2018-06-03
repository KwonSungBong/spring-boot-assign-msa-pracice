package com.example.demo.domain;

import lombok.Data;

public class NotificationDto {

    @Data
    public static class Create {
        private String subject;
        private String content;
    }

    @Data
    public static class Update {
        private String subject;
        private String content;
    }

    @Data
    public static class Search {
        private String subject;
        private String content;
    }

    @Data
    public static class Refer {
        private String id;
    }

}
