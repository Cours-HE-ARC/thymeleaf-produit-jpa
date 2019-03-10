package ch.hearc.spring.thymeleaf.data.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import ch.hearc.spring.thymeleaf.data.ProduitDAO;
import ch.hearc.spring.thymeleaf.model.Produit;
import ch.hearc.spring.thymeleaf.repository.ProduitRepository;

@Profile("h2")
@Component
public class ProduitRepositoryDAO implements ProduitDAO{

	@Autowired
	private ProduitRepository prepo;
	
	@Override
	public List<Produit> findAll() {
		
		List<Produit> produits = new ArrayList<>();
		
		prepo.findAll().forEach(produits::add);
		
		return produits;
	}

	@Override
	public void save(@Valid Produit produit) {
		
		prepo.save(produit);
		
	}

}
