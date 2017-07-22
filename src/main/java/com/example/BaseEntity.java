package com.example;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public class BaseEntity {
	
	protected Integer id;
	protected Date dateOfCreation;
	protected Date dateOfModification;
	protected String createdBy;
	protected String modifiedBy;
	
	
	public BaseEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseEntity(Integer id) {
		this.id = id;
	}
	
	
	public BaseEntity(Integer id, Date dateOfCreation, Date dateOfModification) {
		super();
		this.id = id;
		this.dateOfCreation = dateOfCreation;
		this.dateOfModification = dateOfModification;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@CreatedDate
	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@LastModifiedDate
	public Date getDateOfModification() {
		return dateOfModification;
	}

	public void setDateOfModification(Date dateOfModification) {
		this.dateOfModification = dateOfModification;
	}

	@CreatedBy
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@LastModifiedBy
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "BaseEntity ["
				+ "id=" + id + 
				", dateOfCreation=" + dateOfCreation + 
				", dateOfModification=" + dateOfModification + 
				", createdBy=" + createdBy + 
				", modifiedBy=" + modifiedBy + 
			"]";
	}

}
