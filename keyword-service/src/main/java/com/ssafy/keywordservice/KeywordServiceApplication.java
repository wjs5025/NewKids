package com.ssafy.keywordservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KeywordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeywordServiceApplication.class, args);
	}

}
