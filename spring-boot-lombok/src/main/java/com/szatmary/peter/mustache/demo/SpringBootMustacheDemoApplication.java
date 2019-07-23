package com.szatmary.peter.mustache.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;

@EnableAutoConfiguration(exclude = MustacheAutoConfiguration.class)
@SpringBootApplication
public class SpringBootMustacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMustacheDemoApplication.class, args);
	}
}
