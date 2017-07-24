package com.example;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "DEPT")
public class Department extends BaseEntity {
	
	Long id;
	String name;
	
	List<Employee> employees;
	
	public Department() {	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public Department(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "department", fetch=FetchType.LAZY, orphanRemoval = true)
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department ["+
				"name=" + name + 
				", deptId=" + getId() + 
			"]";
	}

	
}
