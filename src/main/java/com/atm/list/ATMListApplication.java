package com.atm.list;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ATMListApplication {

	public static void main(String[] args) {
		log.info("Starting ATM application");
		SpringApplication.run(ATMListApplication.class, args);
	}

}
