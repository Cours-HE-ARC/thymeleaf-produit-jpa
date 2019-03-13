package ch.hearc.spring.thymeleaf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		   	.authorizeRequests() 
		     .antMatchers("/comptes","/saisie_transfert","/transfert","/comptesperso").authenticated()
		     .and()
		     .formLogin()
		    .and()
		    .authorizeRequests()
			  .antMatchers("/h2/**").permitAll();
			 // .antMatchers("/hack");//.hasAuthority("HACK");
		
		
		
		
		http.csrf().disable();
		
		http.cors();
		
		http.headers().frameOptions().disable();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("SCE").password("{noop}password").roles("USER").authorities("HACK")
				.and()
				.withUser("ADMIN").password("{noop}password").roles("ADMIN");
				
			
			
	}
}
