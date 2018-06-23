package com.turchenkov.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Application {

    @RequestMapping("/reports")
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
