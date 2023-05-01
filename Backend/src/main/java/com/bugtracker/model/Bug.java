package com.bugtracker.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Bug {

	@Id
	@GeneratedValue
	private Long id;
	@NotBlank(message = "Name cannot be blank")
	private String title;
	@NotBlank(message = "Description cannot be blank")
	private String description;
	private Severity severity = Severity.LOW;
	private Status status = Status.UNBEGUN;
	@PastOrPresent
	private Date timeCreated = new java.util.Date();
	@NotNull
//	private User createdBy;
//	private User assignedTo;

	/**
	 * 
	 */
	public Bug() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param severity
	 * @param timeCreated
	 * @param createdBy
	 */
	public Bug(Long id, @NotBlank(message = "Name cannot be blank") String title,
			@NotBlank(message = "Description cannot be blank") String description, Date timeCreated, Severity severity, Status status) {
//			User createdBy) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		//this.timeCreated = timeCreated;
		//this.createdBy = createdBy;
		this.severity = severity;
	}

	public Long getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

//	public User getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(User createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public User getAssignedTo() {
//		return assignedTo;
//	}
//
//	public void setAssignedTo(User assignedTo) {
//		this.assignedTo = assignedTo;
//	}

}
