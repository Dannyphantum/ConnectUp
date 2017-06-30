package connectUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConnectUpController {
	
	@Autowired UserRepository repository;
	
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

}
