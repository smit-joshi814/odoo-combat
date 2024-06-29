package com.odoo.combat.services;

import java.util.List;

import com.odoo.combat.entities.Cities;
import com.odoo.combat.entities.States;

public interface CitiesService {
	  List<Cities> getAllCities();

	    Cities getCityById(Integer cityId);

	    Cities createCity(Cities city);

	    Cities updateCity(Cities city);

	    void deleteCity(Integer cityId);

	    // Additional methods based on your needs (optional)
	    List<Cities> getCitiesByState(States state);
}
