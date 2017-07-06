package connectUp;

import org.springframework.data.repository.CrudRepository;

import connectUp.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

	
}