package com.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cinema.model")
public class CinemaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaServiceApplication.class, args);
	}

}
