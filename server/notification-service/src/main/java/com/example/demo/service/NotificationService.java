package com.example.demo.service;

import com.example.demo.domain.Notification;
import com.example.demo.domain.NotificationDto;
import com.example.demo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Page<Notification> findAll(Pageable pageable) {
        notificationRepository.findBy(pageable);
        return null;
    }

    public Mono<Notification> findById(String id) {
        return notificationRepository.findById(id);
    }

    public void create(NotificationDto.Create notificationDto) {
        Notification notification = new Notification();
        notification.setSubject(notificationDto.getSubject());
        notification.setContent(notificationDto.getContent());
        notificationRepository.save(notification).block();
    }

    public void update(String id, NotificationDto.Update notificationDto) {
        Notification notification = notificationRepository.findById(id).block();
        notification.setSubject(notificationDto.getSubject());
        notification.setContent(notificationDto.getContent());
        notificationRepository.save(notification).block();
    }

    public void delete(String id) {
        notificationRepository.deleteById(id);
    }
}
