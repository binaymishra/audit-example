package com.example;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@RevisionEntity
@Table(name = "REVISION_INFO")
public class RevisionsEntity {
	
    private Long revisionId;

   
    private Date revisionDate;
    
    public RevisionsEntity() {
		// TODO Auto-generated constructor stub
	}

    @Id
	@SequenceGenerator(name = "idGeneratorSequence", sequenceName = "REVISION_SEQ")
	@GeneratedValue(generator="idGeneratorSequence", strategy=GenerationType.SEQUENCE)
    @RevisionNumber
    @Column(name = "REVISION_ID")
	public Long getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(Long revisionId) {
		this.revisionId = revisionId;
	}

	@RevisionTimestamp
	@Column(name = "REVISION_TIMESTAMP")
	public Date getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}

	@Override
	public String toString() {
		return "RevisionsEntity [revisionId=" + revisionId + ", revisionDate=" + revisionDate + "]";
	}
}
