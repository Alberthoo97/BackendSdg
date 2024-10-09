package com.example.SpringBootSDG.model.dto;


public class CountryApiResponseDTO {
	
	private NameDTO name;
	private Long population;
	
	
	public NameDTO getName() {
		return name;
	}
	public void setName(NameDTO name) {
		this.name = name;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	
}
