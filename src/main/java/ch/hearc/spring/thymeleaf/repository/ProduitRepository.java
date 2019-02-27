package ch.hearc.spring.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.spring.thymeleaf.model.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

}
