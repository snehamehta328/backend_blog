package com.example.blogBack;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Configuration

public class BlogBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogBackApplication.class, args);
	}

}
