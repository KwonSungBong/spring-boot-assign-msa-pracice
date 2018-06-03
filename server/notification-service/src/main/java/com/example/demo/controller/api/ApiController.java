package com.example.demo.controller.api;

import com.example.demo.domain.Notification;
import com.example.demo.domain.NotificationDto;
import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notification")
public class ApiController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public void findAll(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.DESC)
                                  Pageable pageable) {
        notificationService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Mono<Notification> findById(@PathVariable("id") String id) {
        return notificationService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody NotificationDto.Create notification) {
        notificationService.create(notification);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") String id, @RequestBody NotificationDto.Update notification){
        notificationService.update(id, notification);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id){
        notificationService.delete(id);
    }

}
