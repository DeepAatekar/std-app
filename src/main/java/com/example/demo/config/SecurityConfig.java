package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	
	@Autowired
	private  UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsServiceImpl);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	
//	@Bean
//	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
//	{
//		http
//		.authorizeHttpRequests()
//		.requestMatchers("/","/login").permitAll()
//		.requestMatchers("/home")
//		.authenticated()
//		.and().csrf().disable()
//		.formLogin().loginPage("/login")
//		.defaultSuccessUrl("/home")
//		.usernameParameter("username")
//		.passwordParameter("password");
//		
//		return http.build();
	//}
	
	
	
	
}
