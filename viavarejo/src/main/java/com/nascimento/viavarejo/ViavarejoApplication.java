package com.nascimento.viavarejo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ViavarejoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViavarejoApplication.class, args);
	}
}
