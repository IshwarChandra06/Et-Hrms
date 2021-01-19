package tech.eikona.ethrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "tech.eikona.ethrms")
@ComponentScan(basePackages = "tech.eikona.ethrms.controller")
@EntityScan(basePackages = "tech.eikona.ethrms.entity")
@EnableJpaRepositories(basePackages = "tech.eikona.ethrms.repository")
@EnableAutoConfiguration
public class EtHrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtHrmsApplication.class, args);
	}

}
