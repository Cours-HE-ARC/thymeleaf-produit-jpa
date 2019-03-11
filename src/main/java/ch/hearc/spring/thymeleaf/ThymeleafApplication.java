package ch.hearc.spring.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.hearc.spring.thymeleaf.model.Role;
import ch.hearc.spring.thymeleaf.model.Utilisateur;
import ch.hearc.spring.thymeleaf.repository.RoleRepository;
import ch.hearc.spring.thymeleaf.repository.UtilisateurRepository;



@SpringBootApplication
public class ThymeleafApplication {

	@Autowired
	private UtilisateurRepository utilisateurRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}
	

	@PostConstruct
	public void initData() {
		Role role = new Role();
		role.setNom("ROLE_ADMIN");
		
		roleRepo.save(role);
		
		Utilisateur u = new Utilisateur();
		u.setUsername("admin");
		u.setMotDePasse(bCryptPasswordEncoder.encode("password"));
		
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		u.setRoles(roles);
		
		utilisateurRepo.save(u);
		
		
	}
}
