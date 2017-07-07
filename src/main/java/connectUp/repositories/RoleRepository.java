package connectUp.repositories;

import org.springframework.data.repository.CrudRepository;

import connectUp.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByRole(String role);
}
