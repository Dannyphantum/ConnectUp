package connectUp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import connectUp.models.Education;
import connectUp.models.User;

@Controller
public class ConnectUpController {
	
	@Autowired UserRepository repository;
	
	@Autowired EducationRepository schoolrepository;
	
	@RequestMapping("/")
	public String landingPage(){
		return "landingpage";
	}
	
	@RequestMapping("/login")
	public String loginPage(Model issaModel){
		issaModel.addAttribute("credentialObject", new User());
		return "login";
	}
	
	@RequestMapping("/home")
	public String homePage(){
		return "homepage";
	}

	@RequestMapping("/school")
	public String addStuff(@Valid Education addschoolin, BindingResult binding, Model schoolModel){
		schoolModel.addAttribute("addingSchoolObject", addschoolin);
		schoolrepository.save(addschoolin);
		return "education";
	}
}
