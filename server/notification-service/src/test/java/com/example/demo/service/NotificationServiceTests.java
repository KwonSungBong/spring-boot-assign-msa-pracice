package com.example.demo.service;

import com.example.demo.domain.Notification;
import com.example.demo.domain.NotificationDto;
import com.example.demo.repository.NotificationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotificationServiceTests {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private NotificationRepository notificationRepository;

	@Test
	public void CREATE() {
		NotificationDto.Create notificationDto = new NotificationDto.Create();
		notificationDto.setSubject("subject");
		notificationDto.setContent("content");
		notificationService.create(notificationDto);

		System.out.println();
	}

	@Test
	public void UPDATE() {
		Flux<Notification> notificationFlux = notificationRepository.findAll();

//		NotificationDto.Create notificationDto = new NotificationDto.Create();
//		notificationDto.setSubject("subject");
//		notificationDto.setContent("content");
//		notificationService.update(notificationDto);

		System.out.println();
	}

	@Test
	public void DELETE() {
		Flux<Notification> notificationFlux = notificationRepository.findAll();

//		notificationService.delete(notificationDto);

		System.out.println();
	}

	@Test
	public void FINDONE() {
		System.out.println();
	}

	@Test
	public void FINDALL() {
		System.out.println();
	}

}
