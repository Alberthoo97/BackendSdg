package com.example.SpringBootSDG.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootSDG.model.response.GetAllCountriesResponse;
import com.example.SpringBootSDG.model.response.UpdateCountryResponse;
import com.example.SpringBootSDG.service.SdgService;


@RestController
@RequestMapping("/api/v1")
public class SdgController {
	
	@Autowired
	private SdgService sdgService;
	
	/**
	 * Controller updateCountry (POST), puerta de entrada para la ejecución del 
	 * servicio updateCountry, actualizar y guardar los registros
	 */
	@PostMapping("/data/country")
	public UpdateCountryResponse updateCountry() {
		UpdateCountryResponse response = sdgService.updateCountry();
		return response;
	}
	
	/**
	 * Controller count (GET), puerta de entrada para la ejecución del 
	 * servicio getCountries, devuelve todos los registros.
	 */
	@GetMapping("/data/country")
	public GetAllCountriesResponse getAllCountries() {
		GetAllCountriesResponse response = sdgService.getAllCountries();
		return response;
	}

}
