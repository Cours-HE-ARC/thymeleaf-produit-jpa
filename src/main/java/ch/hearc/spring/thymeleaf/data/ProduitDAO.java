package ch.hearc.spring.thymeleaf.data;

import java.util.List;

import javax.validation.Valid;

import ch.hearc.spring.thymeleaf.model.Produit;

public interface ProduitDAO {

	List<Produit> findAll();

	void save(@Valid Produit produit);

}
