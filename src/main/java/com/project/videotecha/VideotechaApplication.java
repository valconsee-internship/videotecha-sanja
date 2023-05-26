package com.project.videotecha;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Videotecha", version = "1.0", description = "An application for a small cinema"))
public class VideotechaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideotechaApplication.class, args);
	}

}
