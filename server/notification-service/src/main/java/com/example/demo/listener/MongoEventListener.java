package com.example.demo.listener;

import com.example.demo.domain.Notification;
import com.example.demo.domain.User;
import com.example.demo.filter.AuthWebFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import java.util.Date;

@Configuration
public class MongoEventListener extends AbstractMongoEventListener<Notification> {

    @Autowired
    private AuthWebFilter authWebFilter;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Notification> event) {
        User user = authWebFilter.getAuthUser();

        if(event.getSource().getCreatedBy() == null ||
                event.getSource().getCreatedDate() == null) {
            event.getSource().setCreatedBy(user);
            event.getSource().setCreatedDate(new Date());
        }

        event.getSource().setUpdateBy(user);
        event.getSource().setUpdateDate(new Date());
    }

    @Override
    public void onBeforeSave(BeforeSaveEvent<Notification> event) {
        System.out.println();
    }
}