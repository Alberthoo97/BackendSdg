package com.example.SpringBootSDG.converter;


import com.example.SpringBootSDG.entity.Country;
import com.example.SpringBootSDG.exceptions.ConverterException;
import com.example.SpringBootSDG.model.dto.CountryApiResponseDTO;
import com.example.SpringBootSDG.model.dto.CountryDTO;
import com.example.SpringBootSDG.utils.Constants;

public class CountryConverter {
	
	
	public static Country countryApiDtoToEntity(CountryApiResponseDTO countryDTO) {
		
		try {
			Country country = new Country();

			country.setNameCountry(countryDTO.getName().getCommon());
			country.setPopulation(countryDTO.getPopulation());
			
			return country;
		} catch (Exception ex) {
			throw new ConverterException(Constants.EXCEPTION_CONVERTER);
		}
		

	}
	
	
	public static CountryDTO CountryEntityToDTO(Country country) {
		
		try {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountry(country.getNameCountry());
			countryDTO.setPopulation(country.getPopulation());
			
			return countryDTO;
			
		} catch (Exception ex) {
			throw new ConverterException(Constants.EXCEPTION_CONVERTER);
		}
	}


}
