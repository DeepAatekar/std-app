package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role 
{
	@Id
	@GeneratedValue
	private Long id;

	private String role;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
