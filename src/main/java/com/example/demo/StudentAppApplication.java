package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StudentAppApplication {

	public static void main(String[] args)
	{
		
//		  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		  String password1 = bCryptPasswordEncoder.encode("Deep123");
//		  String password2 = bCryptPasswordEncoder.encode("12345");
		 
		
		
		SpringApplication.run(StudentAppApplication.class, args);
	}

}
