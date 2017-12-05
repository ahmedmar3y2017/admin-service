package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AdminServiceApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);

		// ahmed
		LOGGER.error("Message logged at ERROR level");
		LOGGER.warn("Message logged at WARN level");
		LOGGER.info("Message logged at INFO level");
		LOGGER.debug("Message logged at DEBUG level");

	}

	@RequestMapping("/")
	public String welcome() {
		String name = "kk";
		// if (name.length() == 2) {
		// throw new RuntimeException("Opps exception has occured");
		// }
		return "Hello World!!";
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Done");

	}
}
