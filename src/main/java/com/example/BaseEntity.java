package com.example;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class BaseEntity {
	
	Long id;
	
	public BaseEntity() {	}

	public BaseEntity(Long id) {
		super();
		this.id = id;
	}

	@Id
	@SequenceGenerator(name = "idGeneratorSequence", sequenceName = "ID_GENERATOR_SEQ")
	@GeneratedValue(generator="idGeneratorSequence", strategy=GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + "]";
	}
}
