package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


@Entity
@Audited
@Table(name = "EMP")
public class Employee extends BaseEntity {
	
	String name;
	
	Department department;
	
	public Employee() {	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee(Long id, String name) {
		super(id);
		this.name = name;
	}

	public Employee(String name, Department department) {
		super();
		this.name = name;
		this.department = department;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee ["
				+ "name=" + name 
				+ ", empId=" + getId() 
				+ "]";
	}
}
