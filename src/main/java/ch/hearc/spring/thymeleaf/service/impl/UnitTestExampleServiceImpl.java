package ch.hearc.spring.thymeleaf.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.spring.thymeleaf.repository.ProduitRepository;
import ch.hearc.spring.thymeleaf.service.UnitTestExampleService;

@Service
public class UnitTestExampleServiceImpl implements UnitTestExampleService {

	@Autowired
	ProduitRepository produitRepository;
	
	@Override
	public String getMessage() {
		
		int nbProduits = produitRepository.findByNom("test").size();
		
		return "UnitTestExample, nbProduits: " + nbProduits;
	}

}
