package ch.hearc.spring.thymeleaf.model;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CompteBancaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	
	private String identifiant;
	
	@OneToMany(mappedBy="crediteur")
    private Set<Transfert> credits;
	
	@OneToMany(mappedBy="debiteur")
    private Set<Transfert> debits;
	
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	private int montant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public CompteBancaire(String userName, int montant, String identifiant) {
		super();
		this.userName = userName;
		this.montant = montant;
		this.identifiant = identifiant;
	}

	CompteBancaire() {
		
	}

	@Override
	public String toString() {
		return "CompteBancaire [id=" + id + ", userName=" + userName + ", identifiant=" + identifiant +", montant=" + montant + "]";
	}
	
	
	
}
