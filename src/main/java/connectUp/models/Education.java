package connectUp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // Creates table with the following as columns
public class Education {

	@Id
	@GeneratedValue
	private long id;
	
	private String degree;
	
	private String institution;
	
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
