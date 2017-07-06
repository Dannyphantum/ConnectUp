package connectUp.models;

import javax.persistence.*;

import java.util.Set;

@Entity // Creates table with the following as columns
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	
	private String password;
	
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn (name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id")
	private Set<Education> schoolin;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Education> getSchoolin() {
		return schoolin;
	}

	public void setSchoolin(Set<Education> schoolin) {
		this.schoolin = schoolin;
	}
}
