package de.lubowiecki.ocp.io;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Record implements Serializable {
	
	private static final long serialVersionUID = 5916799774422608233L;
	
	private final LocalDateTime createdAt;
	
	private LocalDateTime doneAt;

	private String label;
	
	private Status status;
	
	public Record() {
		createdAt = LocalDateTime.now();
	}

	public LocalDateTime getDoneAt() {
		return doneAt;
	}

	public void setDoneAt(LocalDateTime doneAt) {
		this.doneAt = doneAt;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
		
		if(status == Status.DONE) {
			doneAt = LocalDateTime.now();
		}
		else {
			doneAt = null;
		}
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
