package com.odoo.combat.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odoo.combat.entities.Cities;
import com.odoo.combat.entities.States;
import com.odoo.combat.services.CitiesService;

@RestController
@RequestMapping("/api/v1/cities")
public class CitiesController {

    @Autowired
    private CitiesService citiesService;

    @GetMapping
    public ResponseEntity<List<Cities>> getAllCities() {
        List<Cities> cities = citiesService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<Cities> getCityById(@PathVariable Integer cityId) {
        Cities city = citiesService.getCityById(cityId);
        if (city != null) {
            return new ResponseEntity<>(city, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Cities> createCity(@RequestBody Cities city) {
        Cities savedCity = citiesService.createCity(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<Cities> updateCity(@PathVariable Integer cityId, @RequestBody Cities city) {
        city.setCityId(cityId); // Ensure city ID matches path variable
        Cities updatedCity = citiesService.updateCity(city);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<Void> deleteCity(@PathVariable Integer cityId) {
        citiesService.deleteCity(cityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byState/{stateId}")
    public ResponseEntity<List<Cities>> getCitiesByState(@PathVariable Integer stateId) {
        States state = new States(); // Assuming you can construct a States object with ID
        state.setStateId(stateId);
        List<Cities> cities = citiesService.getCitiesByState(state);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
