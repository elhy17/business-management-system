package com.atlas.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Data
@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String title;
	
	private String image;
	
	private String description;
	
	@ManyToOne
	private  User user;
	
	private boolean vegetarian;
	
	private LocalDateTime createdAt;
	
	private List<Long> likes = new ArrayList<>();
}
