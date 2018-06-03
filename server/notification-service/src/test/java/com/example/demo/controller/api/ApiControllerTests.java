package com.example.demo.controller.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiControllerTests {

//	@Autowired
//	private WebTestClient webClient;
//
//	@Test
//	public void TEST1() {
//		this.webClient.get().uri("/notification/test").exchange().
//				expectStatus().isOk().
//				expectBody(String.class).isEqualTo("notification");
//	}

}
