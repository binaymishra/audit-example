package com.example;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
	
	@Bean
	CommandLineRunner runner(EmployeeRepository repository){
		return args -> {
			
			repository.save(Arrays.asList(new Employee("John Doe"), new Employee("Jane Doe")));
			
			System.out.println("==== findAll()=====");
			repository.findAll().stream()
				.forEach(emp -> {
					System.err.println(emp);
				});
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
