package com.example.SpringBootSDG.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@Column(name = "name_country", unique = true, nullable = false)
	private String nameCountry;
	
	@Column(name = "population", nullable = false)
	private Long population;

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}
	
}
