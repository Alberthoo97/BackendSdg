package com.example.SpringBootSDG.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootSDG.entity.Country;

public interface SdgRepository extends JpaRepository<Country, String> {


}
