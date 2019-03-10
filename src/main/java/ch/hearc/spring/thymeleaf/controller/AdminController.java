package ch.hearc.spring.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.hearc.spring.thymeleaf.data.ProduitDAO;
import ch.hearc.spring.thymeleaf.repository.ProduitRepository;



@Controller
public class AdminController {

		
		@GetMapping("/admin")
		public String accueil(Map<String, Object> model) {
			model.put("page", "Administration");
			return "admin";
		}
		
}


