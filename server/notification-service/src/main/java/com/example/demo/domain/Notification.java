package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "notification")
public class Notification {

    @Id
    private String id;


    private String subject;
    private String content;


    @Version
    private Long version;

    private Boolean delete = Boolean.FALSE;

    private User createdBy;
    private Date createdDate;
    private User updateBy;
    private Date updateDate;
}
