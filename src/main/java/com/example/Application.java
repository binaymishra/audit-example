package com.example;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	@Bean
	CommandLineRunner runner(EmployeeRepository repository, EmployeeRevisionRepository revisionRepository){
		return args -> {
			repository.save(Arrays.asList(
					new Employee("John Doe")
					)); // create new employee named John Doe
			
			System.out.println("===========findAll()===========");
			repository.findAll().stream().forEach(e -> 
						System.err.println(e)
					);
			
			final Long employeeId = Long.valueOf(1);
			Employee johnDoe = repository.findOne(employeeId); // find John Doe
			
			johnDoe.setName("Jane Doe"); 
			Employee johnToJane = repository.save(johnDoe); // update name to Jane Doe
			
			repository.delete(johnToJane); // delete John Doe / Jane Doe
			
			// Expected three revisions, create , update, delete
						System.out.println("===========findAllRevisions()===========");
						revisionRepository.listOfRevisions(employeeId)
							.stream()
							.forEach(erv -> {
								System.err.println(erv);
							});;
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
