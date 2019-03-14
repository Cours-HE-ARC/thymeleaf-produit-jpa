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
		Role roleAdmin = new Role();
		roleAdmin.setNom("ROLE_ADMIN");
		roleRepo.save(roleAdmin);
		
		Role roleUser = new Role();
		roleUser.setNom("ROLE_USER");
		roleRepo.save(roleUser);
		
		Utilisateur admin = new Utilisateur();
		admin.setUsername("admin");
		admin.setMotDePasse(bCryptPasswordEncoder.encode("password"));
		
		Set<Role> roles = new HashSet<>();
		roles.add(roleAdmin);
		admin.setRoles(roles);
		
		utilisateurRepo.save(admin);
		
		
		Utilisateur user = new Utilisateur();
		user.setUsername("user");
		user.setMotDePasse(bCryptPasswordEncoder.encode("password"));
		
		Set<Role> rolesUser = new HashSet<>();
		rolesUser.add(roleUser);
		admin.setRoles(rolesUser);
		
		utilisateurRepo.save(user);
		
		
	}
}
