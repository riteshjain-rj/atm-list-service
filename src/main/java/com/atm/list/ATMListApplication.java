package com.atm.list;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ATM List API", version = "1.0", description = "This exercise uses the open-api for ATMs Information"))
public class ATMListApplication {

	public static void main(String[] args) {
		log.info("Starting ATM application");
		SpringApplication.run(ATMListApplication.class, args);
	}

}
