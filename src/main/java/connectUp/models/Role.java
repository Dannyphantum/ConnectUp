package connectUp.models;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private long id;
	
	private String role;
	 //This will create three tables in database; user, role, user_role.
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<User> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
