package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRevisionRepository {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	public List<EmployeeRevision> listOfRevisions(Long employeeId){
		final long startTime = System.currentTimeMillis();
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		List<Number> revisionNumber = auditReader.getRevisions(Employee.class, employeeId);
		List<EmployeeRevision> employeeRevisions = new ArrayList<>();
		for (Number revision : revisionNumber) {
			employeeRevisions.add(
					new EmployeeRevision(
							revision.longValue(), 
							auditReader.getRevisionDate(revision), 
							auditReader.find(Employee.class, employeeId, revision))
				);
		}
		System.out.println("Method execution time of listOfRevisions() = "+TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime));
		return employeeRevisions;
	}

}
