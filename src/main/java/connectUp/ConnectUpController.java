package connectUp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import connectUp.models.Education;
import connectUp.models.Job;
import connectUp.models.Skills;
import connectUp.models.User;
import connectUp.repositories.EducationRepository;
import connectUp.repositories.JobRepository;
import connectUp.repositories.SkillsRepository;
import connectUp.repositories.UserRepository;


@Controller
public class ConnectUpController {
	
	@Autowired UserRepository repository;
	
	@Autowired EducationRepository schoolrepository;
	
	@Autowired JobRepository jobrepository;
	
	@Autowired SkillsRepository skillsrepository;
	
	@Autowired private UserValidator userValidator;
	
	@Autowired private UserService userService;
	/*
	@RequestMapping("/")
	public String landingPage(){
		return "landingpage";
	}
	*/
	@RequestMapping("/login")
	public String loginPage(Model issaModel){
		issaModel.addAttribute("credentialObject", new User());
		return "login";
	}
	/*
	@RequestMapping("/signup") //Custom Sign Up page
	public String signupPage(@Valid User credentialObject, BindingResult thatWhichBinds, Model anotherModel){
		repository.save(credentialObject);
		anotherModel.addAttribute("addingNewUserObject", credentialObject);
		return "signuppage";
	}
	*/
	
	@GetMapping("/")
	public String signupGet(Model getModel){
		getModel.addAttribute("newUserObject", new User());
		return "signuppage";
	}
	
	@PostMapping("/")
	public String signupPost(@Valid @ModelAttribute("User") User credentialObject, BindingResult binding, Model yetanotherModel){
		
		yetanotherModel.addAttribute("newUserObject", credentialObject);
		userValidator.validate(credentialObject, binding);
		
		if(binding.hasErrors()){
			return "signuppage";
		} else { 
			userService.saveUser(credentialObject);
			yetanotherModel.addAttribute("message", "User account created!");
		}
		return "signuppage";
	}
	
	public UserValidator getUserValidator() {
	    return userValidator;
	}
	
	public void setUserValidator(UserValidator userValidator) {
	    this.userValidator = userValidator;
	}
	
	@RequestMapping("/home")
	public String homePage(){
		return "homepage";
	}
	
	@GetMapping("/school")
	public String getSchoolStuff(Model schoolModel){
		schoolModel.addAttribute("schoolObject", new Education());
		return "educationpage";
	}

	@PostMapping("/school")
	public String addSchoolStuff(Education addschoolin, BindingResult binding, Model schoolModel){
		schoolModel.addAttribute("schoolObject", addschoolin);
		schoolrepository.save(addschoolin);
		return "educationpage";
	}
	
	@GetMapping("/skills")
	public String getSkills(Model skillModel){
		skillModel.addAttribute("skillObject", new Skills());
		return "skillpage";
	}
	
	@PostMapping("/skills")
	public String addSkillStuff(@Valid Skills addskills, BindingResult binding, Model skillModel){
		skillModel.addAttribute("skillObject", addskills);
		skillsrepository.save(addskills);
		return "skillpage";
	}
	
	@GetMapping("/jobs")
	public String getJobs(Model jobModel){
		jobModel.addAttribute("jobObject", new Job());
		return "jobpage";
		
	}
	@PostMapping("/jobs")
	public String addJobStuff(@Valid Job addjobs, BindingResult binding, Model jobModel){
		jobModel.addAttribute("jobObject", addjobs);
		jobrepository.save(addjobs);
		return "jobpage";
	}
	
	@RequestMapping("/resume")
	public String getResume(){
		return "resumepage";
	}
	
}