package com.example;

import javax.persistence.Entity;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Employee extends BaseEntity {
	
	String name;
	
	public Employee() {	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee(Long id, String name) {
		super(id);
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
		return "Employee [name=" + name + ", id=" + id + "]";
	}
}
