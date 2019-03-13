package ch.hearc.spring.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.hearc.spring.thymeleaf.data.ProduitDAO;
import ch.hearc.spring.thymeleaf.model.Produit;
import ch.hearc.spring.thymeleaf.model.Transfert;
import ch.hearc.spring.thymeleaf.model.TransfertDomaineService;
import ch.hearc.spring.thymeleaf.repository.CompteBancaireRepository;
import ch.hearc.spring.thymeleaf.repository.ProduitRepository;
import ch.hearc.spring.thymeleaf.repository.TransfertRepository;



@Controller
public class BanqueController {

	@Autowired
	CompteBancaireRepository compteBancaireRepository;
	
	@Autowired
	TransfertRepository transfertRepository;
	
		
		
		@GetMapping("/comptes")
		public String comptes(Map<String, Object> model) {
			
			model.put("page", "Compte bancaires");
			
			
			model.put("comptes", compteBancaireRepository.findAll());
			return "comptebancaire";
		}
		
		@PostMapping(value = "/transfert")
	    public String transfer(@Valid @ModelAttribute TransfertDto transfert, BindingResult errors, Model model) {
	       
			TransfertDomaineService transfertSevice = new TransfertDomaineService(compteBancaireRepository,transfertRepository);
			transfertSevice.transfertMontant(transfert.getNoDebiteur(), transfert.getMontant());
			
			
			System.out.println(
	    		   String.format("Transfer to %s", transfert.getNoDebiteur())
			);
	       
	       return ((errors.hasErrors()) ? "saisie_transfert" : "redirect:comptesperso");
	       
	    }
		
		@GetMapping("/comptesperso")
		public String comptesperso(Map<String, Object> model) {
			
			model.put("page", "Compte bancaires");
			
			Authentication aut = SecurityContextHolder.getContext().getAuthentication();
			System.out.println(aut.getName());
			model.put("comptes", compteBancaireRepository.findByUserName(aut.getName()));
			return "comptebancaire";
		}
		
		@GetMapping("/saisie_transfert")
		public String transfert(Map<String, Object> model) {
			
			model.put("page", "Saisir transfert");
			
			
			model.put("comptes_dispo", compteBancaireRepository.findAll());
			model.put("transfert", new TransfertDto());
			return "saisie_transfert";
		}
		
		
		
}


