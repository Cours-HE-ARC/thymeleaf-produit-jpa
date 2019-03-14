package ch.hearc.spring.thymeleaf.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import ch.hearc.spring.thymeleaf.model.Produit;
import ch.hearc.spring.thymeleaf.repository.ProduitRepository;

@Controller
public class ProduitController {

	
	@Autowired
	private ProduitRepository pdao;
	
	//private ProduitRepository prepo;
	
	@GetMapping(value = "/produits")
	public String findAllProduits(Map<String, Object> model){
		System.out.println("/produits GET");
		model.put("produits", pdao.findAll());
		model.put("produit", new Produit());
		
		
		return "produits";
	}
	
	@GetMapping(value = "/saisie_produits")
	public String saisieProduits(Map<String, Object> model){
		
		
		model.put("produit", new Produit());
		
		
		return "saisie_produits";
	}
	
	@PostMapping("/produits")
	public String saveProduits(@Valid @ModelAttribute Produit produit, BindingResult errors, Model model) {
		
		
		if (!errors.hasErrors()) {
            pdao.save(produit);
        }
        return ((errors.hasErrors()) ? "saisie_produits" : "redirect:produits");
	}
}
