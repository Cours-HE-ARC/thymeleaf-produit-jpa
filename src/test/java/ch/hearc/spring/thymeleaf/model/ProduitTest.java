package ch.hearc.spring.thymeleaf.model;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class ProduitTest {

	@Test
	public void givenAProductInstanceWithPrice15_whenCallIsCher_thenCallReturnTrue() {

	  Produit p = new Produit();
	  p.setPrix(new BigDecimal("15.00"));

	  assertTrue(p.isCher());
	}

}
