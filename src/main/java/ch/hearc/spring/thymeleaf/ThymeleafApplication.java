package ch.hearc.spring.thymeleaf;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.hearc.spring.thymeleaf.model.CompteBancaire;
import ch.hearc.spring.thymeleaf.model.Transfert;
import ch.hearc.spring.thymeleaf.model.TransfertDomaineService;
import ch.hearc.spring.thymeleaf.repository.CompteBancaireRepository;
import ch.hearc.spring.thymeleaf.repository.TransfertRepository;



@SpringBootApplication
public class ThymeleafApplication {

	@Autowired
	CompteBancaireRepository compteBancaireRepository;
	
	@Autowired
	TransfertRepository transfertRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}
	
	@PostConstruct
	public void initCompteBancaire() {
		
		
		CompteBancaire cpt1 = new CompteBancaire("SCE", 2000, "SCE-1234");
		compteBancaireRepository.save(cpt1);
		System.out.println("Compte1 créé: " + cpt1);
		
		CompteBancaire cpt2 = new CompteBancaire("[ATTACKER]",100, "ATTACKER-123");
		compteBancaireRepository.save(cpt2);
		System.out.println("Compte2 créé: " + cpt2);
		
		TransfertDomaineService service = new TransfertDomaineService(compteBancaireRepository,transfertRepository);
		service.transfertMontant(cpt2.getIdentifiant(), 1000);
		
		
	}
	
}
