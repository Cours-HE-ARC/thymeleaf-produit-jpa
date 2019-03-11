package ch.hearc.spring.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.spring.thymeleaf.model.Role;
import ch.hearc.spring.thymeleaf.model.Utilisateur;

public interface RoleRepository extends CrudRepository<Role, Long>{
}
