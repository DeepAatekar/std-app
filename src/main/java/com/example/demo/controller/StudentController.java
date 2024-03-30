package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController 
{
	@GetMapping(value = {"/","/login"})
	public ModelAndView login() 
	{
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@GetMapping("/home")
	@PreAuthorize("hasAuthority('STUDENT')")
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
}
