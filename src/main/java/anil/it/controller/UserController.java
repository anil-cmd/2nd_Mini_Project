package anil.it.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import anil.it.binding.LoginForm;
import anil.it.binding.RegistrationForm;
import anil.it.binding.UpdatePasswordForm;
import anil.it.entity.User;
import anil.it.props.AppProps;
import anil.it.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AppProps appProps;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "index";	
	}
	
	@GetMapping("/login")
	public String login(LoginForm loginForm, Model model) {
		User user = userService.loginCheck(loginForm);
		if(user == null) {
			model.addAttribute("msg", appProps.getMessages().get("invalidLogin"));
			return "index";
		}
		
		if(user.getPasswordUpdated().equals("No")) {
			UpdatePasswordForm updatePasswordForm = new UpdatePasswordForm();
			updatePasswordForm.setUserId(user.getUserId());
			model.addAttribute("updatePasswordForm", updatePasswordForm);
			return "set_new_password";
		}
		
		return "redirect:quote";
		
	}
	
	@GetMapping("/register")
	public String registrationPage(Model model) {
		
		Map<Integer, String> countries = userService.getCountries();
		model.addAttribute("countries", countries);

		model.addAttribute("user", new RegistrationForm());

		return "Registration_page";
		
	}

	@GetMapping("/get-states")
	@ResponseBody
	public Map<Integer, String> loadStates(@RequestParam("countryId") Integer countryId){
		return userService.getStates(countryId);
	}

	@GetMapping("/get-cities")
	@ResponseBody
	public Map<Integer, String> loadCities(@RequestParam("stateId") Integer stateId){
		return userService.getCities(stateId);
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") RegistrationForm user, Model model) {
		
		boolean saved = userService.registerUser(user);
		if (saved) {
			model.addAttribute("msg", appProps.getMessages().get("userSaved"));
		}else {
			model.addAttribute("msg", appProps.getMessages().get("userNotSaved"));
		}
		
		return "Registration_page";
		
	}
	
	
	@PostMapping("/set-password")
	public String resetPassword(@ModelAttribute("updatePasswordForm")UpdatePasswordForm updatePasswordForm, Model model) {
		
		boolean status = userService.updatePassword(updatePasswordForm);
		if(status) {
			return "redirect:quote";
		}
		model.addAttribute("msg", appProps.getMessages().get("passwordNotUpdated"));
		return "set_new_password";
		
	}

}
