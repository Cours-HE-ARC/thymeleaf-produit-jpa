package ch.hearc.spring.thymeleaf.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import ch.hearc.spring.thymeleaf.model.Produit;
import ch.hearc.spring.thymeleaf.repository.ProduitRepository;
import ch.hearc.spring.thymeleaf.service.UnitTestExampleService;

@RunWith(SpringRunner.class)
public class UnitTestExampleServiceImpleTest {

	@Autowired
    private UnitTestExampleService unitTestExampleService;
	
	//Evite le scannage des implémentations
	//Permet de fournir une implémentation pour les test
	@TestConfiguration
    static class UnitTestExampleServiceImpleTestConfiguration {
  
        @Bean
        public UnitTestExampleService employeeService() {
            return new UnitTestExampleServiceImpl();
        }
    }
	
	
 
	//Bean destiné à être simulé
    @MockBean
    private ProduitRepository produitRepository;
    
    //Exécution avant chaque méthode @Test
    @Before
    public void setUp() {
     
        Mockito.when(produitRepository.findByNom("test"))
          .thenReturn(new ArrayList());
    }
    
    @Test
    public void fakeExampleTest() {
        String message = unitTestExampleService.getMessage();
        
        assertThat(message).isEqualTo("UnitTestExample, nbProduits: 0");
     }
}
