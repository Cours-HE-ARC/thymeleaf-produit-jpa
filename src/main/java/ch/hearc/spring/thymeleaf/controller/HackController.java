package ch.hearc.spring.thymeleaf.controller;

import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HackController {
	
	
	@GetMapping("/hack")
	public String accueil(Map<String, Object> model) {
		
		return "attacker_page";
	}
}
