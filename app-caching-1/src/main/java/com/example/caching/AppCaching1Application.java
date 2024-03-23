package com.example.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AppCaching1Application {

	public static void main(String[] args) {
		SpringApplication.run(AppCaching1Application.class, args);
	}

}
