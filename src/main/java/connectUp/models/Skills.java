package connectUp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // Creates table with the following as columns
public class Skills {

	@Id
	@GeneratedValue
	private long id;
	
	private String skills;
	
	private String proficiency;

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getProficiency() {
		return proficiency;
	}

	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
