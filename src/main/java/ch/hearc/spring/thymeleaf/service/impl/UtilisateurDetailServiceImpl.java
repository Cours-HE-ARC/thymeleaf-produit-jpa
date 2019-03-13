package ch.hearc.spring.thymeleaf.service.impl;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.hearc.spring.thymeleaf.model.Role;
import ch.hearc.spring.thymeleaf.model.Utilisateur;
import ch.hearc.spring.thymeleaf.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.User;

@Service
public class UtilisateurDetailServiceImpl implements UserDetailsService {

	@Autowired
    private UtilisateurRepository utilisateurRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur utilisateur = utilisateurRepository.findByNomUtilisateur(username);
        if (utilisateur == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : utilisateur.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getNom()));
        }

        return new User(utilisateur.getNomUtilisateur(), utilisateur.getMotDePasse(), grantedAuthorities);
	}

}
