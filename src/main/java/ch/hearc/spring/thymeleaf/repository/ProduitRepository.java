package ch.hearc.spring.thymeleaf.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.spring.thymeleaf.model.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

	public List<Produit> findByNom(String nom);
}
