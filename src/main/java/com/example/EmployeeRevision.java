package com.example;

import java.util.Date;

public class EmployeeRevision {
	
	Long revisionId;
	Date revisionDate;
	Employee employee;
	
	public EmployeeRevision() {	}

	public EmployeeRevision(Long revisionId, Date revisionDate, Employee employee) {
		super();
		this.revisionId = revisionId;
		this.revisionDate = revisionDate;
		this.employee = employee;
	}

	public Long getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(Long revisionId) {
		this.revisionId = revisionId;
	}

	public Date getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeRevision ["+ 
				"revisionId=" + revisionId + 
				", revisionDate=" + revisionDate + 
				", employee="+ employee + 
			"]";
				
	}
	
	

}
