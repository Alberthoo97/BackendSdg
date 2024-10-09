package com.example.SpringBootSDG.service;

import com.example.SpringBootSDG.model.response.GetAllCountriesResponse;
import com.example.SpringBootSDG.model.response.UpdateCountryResponse;

public interface SdgService {
	
	public UpdateCountryResponse updateCountry();
	public GetAllCountriesResponse getAllCountries();
}
