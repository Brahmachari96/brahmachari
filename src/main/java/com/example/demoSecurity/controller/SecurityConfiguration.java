package com.example.demoSecurity.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	   http
	   .csrf().disable()
	   .authorizeRequests()
	   .antMatchers(HttpMethod.GET, "/api/auth/**").permitAll()
	   .antMatchers("/api/auth/**").permitAll()
	   .anyRequest()
	   .authenticated();
		
	}
	
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		 UserDetails details= User.builder().username("Chary")
				 .password("{noop}hero") 
				 .roles("User","Admin")
				 .build();
		
			  UserDetails user=User.builder()
					  .username("Brahmachari")
			           .password("{noop}lokesh")
			           .roles("Admin")
			           .build();
			 
		return new InMemoryUserDetailsManager(details,user);
	}

}
