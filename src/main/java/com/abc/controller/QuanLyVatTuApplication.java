package com.abc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.abc.controller"})
@EntityScan("com.abc.entity")
@EnableJpaRepositories("com.abc.repository")
public class QuanLyVatTuApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanLyVatTuApplication.class, args);
	}

}
