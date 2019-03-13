package ch.hearc.spring.thymeleaf.model;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.spring.thymeleaf.repository.CompteBancaireRepository;
import ch.hearc.spring.thymeleaf.repository.TransfertRepository;


public class TransfertDomaineService {

	
	CompteBancaireRepository compteBancaireRepository;
	
	
	TransfertRepository transfertRepository;
	
	public TransfertDomaineService(CompteBancaireRepository compteBancaireRepository,TransfertRepository transfertRepository ) {
		this.transfertRepository = transfertRepository;
		this.compteBancaireRepository = compteBancaireRepository;
		
	}

	private CompteBancaire findCompteUserLogged() {
		// TODO Auto-generated method stub
		return compteBancaireRepository.findByUserName("SCE");
	}

	private CompteBancaire findCompteByNoCompte(String noCompte) {
		System.out.println("Find by no compte  :" + noCompte);
		return compteBancaireRepository.findByIdentifiant(noCompte);
	}

	@Transactional
	public boolean transfertMontant(String noCompte, int transfert) {
		CompteBancaire crediteur = findCompteByNoCompte(noCompte);
		CompteBancaire debiteur = findCompteUserLogged();
		
		System.out.println("Compte crediteur  :" + debiteur.getIdentifiant());
		System.out.println("Compte debiteur  :" + crediteur.getIdentifiant());
		
		if(debiteur.getMontant() - transfert < 0) {
			throw new RuntimeException("Not sufficient found on debiteur account: " + debiteur.getMontant());
		}
		Transfert t = new Transfert(debiteur,crediteur,transfert);
		
		t =  transfertRepository.save(t);
		System.out.println("Transfert  :" + t);
		
		
		if(t.getId() != null) {
			int crediTeurSolde = crediteur.getMontant() + transfert;
			crediteur.setMontant(crediTeurSolde);
			compteBancaireRepository.save(crediteur);
			
			int debiTeurSolde = debiteur.getMontant() - transfert;
			debiteur.setMontant(debiTeurSolde);
			compteBancaireRepository.save(debiteur);
			return true;
		}else {
			return false;
		}
	}
}
