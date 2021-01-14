package com.thrivent.barbershop.barbershopweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.thrivent.barbershop.barbershopweb.service","com.thrivent.barbershop.barbershopweb.controller"})
//@EntityScan("com.thrivent.barbershop.barbershopweb.domain")
//@EnableJpaRepositories("com.thrivent.barbershop.barbershopweb.repository")
public class BarbershopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbershopApplication.class, args);
	}
}
