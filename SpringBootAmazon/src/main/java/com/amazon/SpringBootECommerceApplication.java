package com.amazon;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@PropertySource("classpath:amazon.properties")
@OpenAPIDefinition
public class SpringBootECommerceApplication {
	public static Logger logger=Logger.getLogger("amazon");
	public static void main(String[] args) {
		PropertyConfigurator.configure("D:/TrainingPrograms/SpringBootAmazon/src/main/resources/amazon.properties");
		SpringApplication.run(SpringBootECommerceApplication.class, args);
	}

}
