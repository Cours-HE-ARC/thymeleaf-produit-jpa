package ch.hearc.spring.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.hearc.spring.thymeleaf.model.CompteBancaire;

@Repository
public interface CompteBancaireRepository extends CrudRepository<CompteBancaire, Long>{

	public CompteBancaire findByIdentifiant(String identifiant);
	
	public CompteBancaire findByUserName(String identifiant);
}
