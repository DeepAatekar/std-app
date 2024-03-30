package com.example.demo.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter
{
	
	@Autowired
	public void configureGloabl(AuthenticationManagerBuilder auth)
	{
		auth.authenticationProvider(keycloakAuthenticationProvider());
	}
	
	
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) 
//	{
//		auth.authenticationProvider(keycloakAuthenticationProvider());
//	}
	
	
//
//	@Override
//	public void init(WebSecurity builder) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void configure(WebSecurity builder) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
	
	@Bean
	KeycloakConfigResolver keycloakConfigResolver()
	{
		return new KeycloakSpringBootConfigResolver();
	}

	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		// TODO Auto-generated method stub
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}
//	
//	
//	@Bean
//	KeycloakConfigResolver keycloakConfigResolver() 
//	{
//		return new KeycloakSpringBootConfigResolver();
//	}
//	
//	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.authorizeRequests().antMatchers("contact-us").permitAll()
		.anyRequest().authenticated();
		//.and().exceptionHandling().accessDeniedPage("/access-denied");
	}
	

	
}
