package com.odoo.combat.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odoo.combat.entities.Cities;
import com.odoo.combat.entities.States;
import com.odoo.combat.repositories.CitiesRepository;
import com.odoo.combat.services.CitiesService;

@Service
public class CitiesServiceImpl implements CitiesService {
	@Autowired
    private CitiesRepository citiesRepository;

    @Override
    public List<Cities> getAllCities() {
        return citiesRepository.findAll();
    }

    @Override
    public Cities getCityById(Integer cityId) {
        Optional<Cities> optionalCity = citiesRepository.findById(cityId);
        return optionalCity.orElse(null);
    }

    @Override
    public Cities createCity(Cities city) {
        return citiesRepository.save(city);
    }

    @Override
    public Cities updateCity(Cities city) {
        return citiesRepository.save(city);
    }

    @Override
    public void deleteCity(Integer cityId) {
        citiesRepository.deleteById(cityId);
    }

    @Override
    public List<Cities> getCitiesByState(States state) {
        return citiesRepository.findByState(state);
    }

    // Implement additional methods based on your needs

}
