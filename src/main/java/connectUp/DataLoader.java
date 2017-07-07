package connectUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import connectUp.models.Role;
import connectUp.repositories.RoleRepository;
import connectUp.repositories.UserRepository;
/*
@Component
public class DataLoader implements CommandLineRunner {

	@Autowired UserRepository repository;

	@Autowired RoleRepository roleRepository;

@Override
public void run(String... strings) throws Exception{
	
	roleRepository.save(new Role("Job Seeker"));
	  
    roleRepository.save(new Role("Recruiter"));
    
	}

}
*/