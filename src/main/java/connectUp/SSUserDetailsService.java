package connectUp;


import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import javax.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import connectUp.models.Education;
import connectUp.models.Role;
import connectUp.models.User;
import connectUp.repositories.UserRepository;


@Transactional
public class SSUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SSUserDetailsService.class);
	
	private UserRepository userRepository;
	
	public SSUserDetailsService(UserRepository userRepository){
		this.userRepository=userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userRepository.findByUsername(username);
			if (user == null) {
				LOGGER.debug("user not found with the provided username");
				return null;
			}
			
			LOGGER.debug("user from username " + user.toString());
			if(!user.isEnabled()){
				LOGGER.debug("user not enabled");
				return null;		
				}
			return new
					
		org.springframework.security.core.userdetails.User(user.getUsername(),
		user.getPassword(), getAuthorities(user));
		}
		catch (Exception e){
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	private Set<GrantedAuthority> getAuthorities (User user){
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new
					SimpleGrantedAuthority(role.getRole());
			authorities.add(grantedAuthority);
		}
		LOGGER.debug("user authorities are " + authorities.toString());
		return authorities;
	}
	/*
	private Set<Education> getEducation (User user){
		Set<Education> education = new HashSet<Education>();
		for (Education school : user.getSchoolin()){
					education.add(school);
		}
		LOGGER.debug("Education " + education.toString());
				return education;
	}
	*/
}