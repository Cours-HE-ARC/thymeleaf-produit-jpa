package ch.hearc.spring.thymeleaf.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    private UserDetailsService userDetailsService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    	
    	/**auth
            .inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN");*/
    }
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/h2/**").permitAll()
			.and()
			.authorizeRequests()
				.antMatchers("/").permitAll()
			.and()
			.authorizeRequests()	
				.antMatchers("/admin").authenticated()
				.and()
				.formLogin();
		
		http.csrf().disable();
        http.headers().frameOptions().disable();
	}
    
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
    
}