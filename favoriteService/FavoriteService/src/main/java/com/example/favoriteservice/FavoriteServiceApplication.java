package com.example.favoriteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FavoriteServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(FavoriteServiceApplication.class, args);
	}

}
