package ch.hearc.spring.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.spring.thymeleaf.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
	Utilisateur findByNomUtilisateur(String nomUtilisateur);
}
