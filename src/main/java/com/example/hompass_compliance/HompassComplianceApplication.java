package com.example.hompass_compliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HompassComplianceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HompassComplianceApplication.class, args);
	}

}
