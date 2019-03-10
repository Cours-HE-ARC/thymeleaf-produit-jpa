package ch.hearc.spring.thymeleaf.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ProduitTest {

	private Validator validator;
	
	
	
	@Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
	
	@Test
	public void givenANameAndAPrice_whenCreateInstance_thenInstanceIsCorrect() {
		String produitNom = "IPhone";
		BigDecimal prix = new BigDecimal("760.00");
		
		Produit p = new Produit(produitNom,prix);
		
		
		assertTrue(p != null);
		assertTrue(p.getNom() != null);
		assertTrue(p.getPrix() != null);
		
	}
	
	
	@Test
	public void givenANameWithSizeLessThan2_whenCreateInstance_thenExceptionMusstBeThrown() {
		
		String produitNom = "I";
		BigDecimal prix = new BigDecimal("760.00");
			
		Produit p = new Produit(produitNom,prix);
		
		Set<ConstraintViolation<Produit>> violations = validator.validate(p);
		
		assertFalse(violations.isEmpty());
		
		violations.forEach(violation -> {
			System.out.println(violation);
		});
	
	}

}
