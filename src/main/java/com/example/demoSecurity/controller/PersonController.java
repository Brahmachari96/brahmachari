package com.example.demoSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@PreAuthorize("hasRole('Admin')")
	@GetMapping("hii")
	public String login()
	{
		return "Hi chari";
	}
	
	  @PreAuthorize("hasRole('User')")
	  @GetMapping("sir") 
	  public String m1()
	  {
		  return "lovely boy"; 
	  }
	  
	  @GetMapping("/api/auth/security")
	  public String SecurityName()
	  {
		  return "Security boy"; 
	  }
	 
}
