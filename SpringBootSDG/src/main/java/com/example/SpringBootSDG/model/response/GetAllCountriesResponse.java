package com.example.SpringBootSDG.model.response;

import java.util.List;

import com.example.SpringBootSDG.model.dto.CountryDTO;

public class GetAllCountriesResponse extends Response {
	
	private List<CountryDTO> countries;
	
	
	public GetAllCountriesResponse() {
		this.setOk(false);
	}


	public List<CountryDTO> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryDTO> countries) {
		this.countries = countries;
	}
	
	

}
