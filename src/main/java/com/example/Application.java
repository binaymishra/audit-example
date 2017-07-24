package com.example;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
public class Application {
	
	
	@Bean
	DataSource h2(){
		return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.H2)
					.addScripts("schema.sql", "schema-audit.sql")
					.build();
	}
	
	@Bean
	CommandLineRunner runner(
			EmployeeRepository employeeRepository, 
			DepartmentRepositroy departmentRepositroy,
			EmployeeRevisionRepository revisionRepository){
		
		return args -> {
			departmentRepositroy.save(
					Arrays.asList(
							new Department("SALES"), 
							new Department("MARKETING")
							)
					);
			
			departmentRepositroy.findAll().stream()
				.forEach(dept -> {
					System.err.println(dept);
				});
			
			
			Department salesDepartment = departmentRepositroy.findOne(1L);
			employeeRepository.save(
					Arrays.asList(
								new Employee("John Doe", salesDepartment),
								new Employee("Amit Kumar", salesDepartment)
							)
				);
			
			employeeRepository.findAll()
				.stream()
				.forEach(emp -> {
					System.err.println(emp + "--> "+emp.getDepartment());
				});
			
			final Long employeeId = Long.valueOf(50);
			Employee johnDoe = employeeRepository.findOne(employeeId); // find John Doe
			
			johnDoe.setName("Jane Doe"); 
			Employee johnToJane = employeeRepository.save(johnDoe); // update name to Jane Doe
			
			employeeRepository.findAll().stream().forEach(emp -> System.err.println(emp + "--> "+emp.getDepartment())); 
			
			employeeRepository.delete(johnToJane); // delete John Doe / Jane Doe
			
			employeeRepository.findAll().stream().forEach(emp -> System.err.println(emp + "--> "+emp.getDepartment())); 
			
			departmentRepositroy.findAll().stream()
			.forEach(dept -> {
				System.err.println(dept);
			});
			
			
			
			// Expected three revisions, create , update, delete
			System.out.println("===========findAllRevisions()===========");
			revisionRepository.listOfRevisions(50L)
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
