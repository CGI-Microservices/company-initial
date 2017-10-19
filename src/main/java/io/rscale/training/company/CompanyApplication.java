package io.rscale.training.company;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Level;

@SpringBootApplication
public class CompanyApplication {

	private static final Logger logger = Logger.getLogger(CompanyApplication.class);
	
	public static void main(String[] args) {
		logger.info("--- Reached the Company App...");
		SpringApplication.run(CompanyApplication.class, args);
	}
}
