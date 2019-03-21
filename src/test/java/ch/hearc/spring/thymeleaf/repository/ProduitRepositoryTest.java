package ch.hearc.spring.thymeleaf.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import ch.hearc.spring.thymeleaf.model.Produit;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProduitRepositoryTest {

    @Autowired
    //Fourni par spring
    private TestEntityManager entityManager;
 
    @Autowired
    private ProduitRepository produitRepository;
    
    @Test
    public void givenProduit_whenPersistProduit_thenProduitIsPersisted() {
     //Given, etat
     Produit produit = new Produit();
     produit.setPrix(BigDecimal.ONE);
     produit.setNom("test produit");
     
     entityManager.persist(produit);
     entityManager.flush();
     
     //When, action
     Optional<Produit> produitRecherche = produitRepository.findById(produit.getId());
     
     //Then, resultat
     assertTrue(produitRecherche.isPresent());
     assertTrue(produitRecherche.get().getId().equals(produit.getId()));
     //AssertJ example
     assertThat(produitRecherche.get()).isNotNull();
     
    }

}

