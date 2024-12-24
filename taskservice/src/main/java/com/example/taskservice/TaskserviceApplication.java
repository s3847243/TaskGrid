package com.example.taskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TaskserviceApplication {

	// @Bean
	// public RestTemplate restTemplate()
	// {
	// 	return new RestTemplate();
	// }
	// @Bean
	// public WebClient webClient(){
	// 	return WebClient.builder().build();

	// }

	public static void main(String[] args) {
		SpringApplication.run(TaskserviceApplication.class, args);
	}

}
