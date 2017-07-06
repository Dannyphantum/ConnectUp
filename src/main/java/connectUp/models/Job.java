package connectUp.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity  // Creates table with the following as columns
public class Job {

	@Id
	@GeneratedValue
	private long id;
	
	private String jobTitle;
	
	private String jobCompany;

	LocalDateTime startDate;
	
	LocalDateTime endDate;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobCompany() {
		return jobCompany;
	}

	public void setJobCompany(String jobCompany) {
		this.jobCompany = jobCompany;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
}
