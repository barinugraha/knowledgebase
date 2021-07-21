package com.dom.kb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KnowledgebaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgebaseApplication.class, args);
	}

}
