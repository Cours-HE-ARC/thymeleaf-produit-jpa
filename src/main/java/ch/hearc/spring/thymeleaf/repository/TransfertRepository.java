package ch.hearc.spring.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.hearc.spring.thymeleaf.model.Transfert;

@Repository
public interface TransfertRepository extends CrudRepository<Transfert, Long>{

}
