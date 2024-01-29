package anil.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import anil.it.service.DashboardService;

@Controller
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/quote")
	public String newQuote(Model model) {
		
		String quote = dashboardService.getQuote();
		model.addAttribute("quote", quote);
		return "dashboard";
	}

}
