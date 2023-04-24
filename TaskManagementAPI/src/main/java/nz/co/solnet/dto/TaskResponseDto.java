package nz.co.solnet.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TaskResponseDto {
	
	
	private long id;
	private String title;
	private String description;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate due_date;
	private String status;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate creation_date;
	
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}
	

}
