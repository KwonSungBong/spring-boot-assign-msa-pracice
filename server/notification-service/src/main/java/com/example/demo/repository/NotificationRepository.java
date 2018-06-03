package com.example.demo.repository;

import com.example.demo.domain.Notification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NotificationRepository extends ReactiveMongoRepository<Notification, String> {

    Flux<Notification> findBy(Pageable pageable);
    Flux<Notification> findBySubject(String subject, Pageable pageable);
}
