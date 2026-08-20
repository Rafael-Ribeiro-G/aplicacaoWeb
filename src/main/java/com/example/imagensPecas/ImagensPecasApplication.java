package com.example.imagensPecas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImagensPecasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImagensPecasApplication.class, args);
	}

}
