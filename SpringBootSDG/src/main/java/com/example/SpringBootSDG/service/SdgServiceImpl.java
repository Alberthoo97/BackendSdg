package com.example.SpringBootSDG.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.SpringBootSDG.converter.CountryConverter;
import com.example.SpringBootSDG.dao.SdgRepository;
import com.example.SpringBootSDG.entity.Country;
import com.example.SpringBootSDG.exceptions.ConverterException;
import com.example.SpringBootSDG.model.dto.CountryApiResponseDTO;
import com.example.SpringBootSDG.model.dto.CountryDTO;
import com.example.SpringBootSDG.model.response.GetAllCountriesResponse;
import com.example.SpringBootSDG.model.response.UpdateCountryResponse;

@Service
public class SdgServiceImpl implements SdgService {

	@Autowired
	private SdgRepository sdgRepository;

	@Autowired
	private Environment environment;

	@Autowired
	private WebClient webClient;

	/**
	 * Llama a la api restcountries para obtener los datos actualizados y los inserta en BD.
	 */
	@Override
	@Transactional
	public UpdateCountryResponse updateCountry() {

		UpdateCountryResponse response = new UpdateCountryResponse();

		String url = environment.getProperty("url.restCountries.updateCountry");

		List<CountryApiResponseDTO> countries = webClient.get().uri(url).retrieve().bodyToFlux(CountryApiResponseDTO.class).collectList()
				.block();

		List<Country> countriesEntity = new ArrayList<Country>();
		try {
			countries.forEach(v -> countriesEntity.add(CountryConverter.countryApiDtoToEntity(v)));
		} catch (ConverterException ex) {
			response.setOk(false);
			response.setMsgError(ex.getLocalizedMessage());
			return response;
		}

		sdgRepository.saveAll(countriesEntity);

		response.setOk(true);

		return response;

	}

	/**
	 * Devuelve un DTO con todos los datos de la base de datos.
	 */
	@Override
	public GetAllCountriesResponse getAllCountries() {
		GetAllCountriesResponse response = new GetAllCountriesResponse();

		List<Country> countriesEntity = sdgRepository.findAll();
		
		List<CountryDTO> countries = new ArrayList<CountryDTO>();
		try {
			countriesEntity.forEach(v -> countries.add(CountryConverter.CountryEntityToDTO(v)));
		} catch (ConverterException ex) {
			response.setOk(false);
			response.setMsgError(ex.getLocalizedMessage());
			return response;
		}
		response.setOk(true);
		response.setCountries(countries);
		return response;
	}

}
