package ch.hearc.spring.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.hearc.spring.thymeleaf.data.ProduitDAO;
import ch.hearc.spring.thymeleaf.repository.ProduitRepository;
import ch.hearc.spring.thymeleaf.service.UnitTestExampleService;



@Controller
public class AccueilController {

		@Autowired
		UnitTestExampleService unitTestExampleService;
		
	
		
		@Value("${accueil.message:test}")
		private String message;
		
		@Value("${accueil1.message:[default]}")
		private String messageParDefaut;

		@GetMapping("/")
		public String accueil(Map<String, Object> model) {
			model.put("page", "Accueil");
			return "accueil";
		}
		
		@GetMapping("/basic")
		public String basic(Map<String, Object> model) {
			model.put("message", this.message);
			model.put("page", "Concepts de bases");
			
			model.put("message", this.message);
			model.put("messageParDefaut", this.messageParDefaut);
			model.put("page", "Concepts de bases");
			
			
			//model.put("produits", produitDao.findAll());
			return "basic";
		}
		
		@GetMapping("/unit-test")
		public ResponseEntity<String> unitTestExample() {
			
			String message = unitTestExampleService.getMessage();
			
			return ResponseEntity.ok(message);
		}
		
		
		
}


