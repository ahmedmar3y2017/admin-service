package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);

		// ahmed

	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Done");

	}
}
