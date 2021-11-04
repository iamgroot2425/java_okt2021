package de.lubowiecki.todos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// POJO - Planin Old Java Object

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private int id;
	
	private LocalDate createdAt;
	
	@Column(length = 100)
	private String title;
	
	private String description;
	
	@Column(nullable = true)
	private LocalDate doneAt;
	
	public Task(LocalDate createdAt, String title, String description, LocalDate doneAt) {
		this.createdAt = createdAt;
		this.title = title;
		this.description = description;
		this.doneAt = doneAt;
	}
	
	public Task(LocalDate createdAt, String title, String description) {
		this(createdAt, title, description, null);
	}
	
	public Task(String title, String description) {
		this(LocalDate.now(), title, description);
	}
	
	public Task() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

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

	public LocalDate getDoneAt() {
		return doneAt;
	}

	public void setDoneAt(LocalDate doneAt) {
		this.doneAt = doneAt;
	}
	
	public boolean isDone() {
		return this.doneAt != null;
	}
}
