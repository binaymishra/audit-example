package com.example;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee extends BaseEntity{

	String name;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "Employee [id=" + getId() + 
				", name=" + name + 
				", dateOfCreation=" + getDateOfCreation() + 
				", dateOfModification="+ getDateOfModification() + 
				", createdBy="+ getCreatedBy() + 
				", modifiedBy="+ getModifiedBy() + 
			"]";
				
	}

	
}
