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

import com.odoo.combat.entities.SpecialPickup;
import com.odoo.combat.services.SpecialPickupService;

@RestController
@RequestMapping("/api/v1/special-pickups")
public class SpecialPickupController {

    @Autowired
    private SpecialPickupService specialPickupService;

    @PostMapping
    public ResponseEntity<SpecialPickup> createSpecialPickup(@RequestBody SpecialPickup specialPickup) {
        SpecialPickup savedPickup = specialPickupService.createSpecialPickup(specialPickup);
        return new ResponseEntity<>(savedPickup, HttpStatus.CREATED);
    }

    @GetMapping("/{pickupId}")
    public ResponseEntity<SpecialPickup> getSpecialPickupById(@PathVariable Long pickupId) {
        SpecialPickup specialPickup = specialPickupService.getSpecialPickupById(pickupId);
        if (specialPickup != null) {
            return new ResponseEntity<>(specialPickup, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<SpecialPickup>> getAllSpecialPickups() {
        List<SpecialPickup> specialPickups = specialPickupService.getAllSpecialPickups();
        return new ResponseEntity<>(specialPickups, HttpStatus.OK);
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<SpecialPickup>> getSpecialPickupsByUserId(@PathVariable Long userId) {
        List<SpecialPickup> specialPickups = specialPickupService.getSpecialPickupsByUserId(userId);
        return new ResponseEntity<>(specialPickups, HttpStatus.OK);
    }

    @PutMapping("/{pickupId}")
    public ResponseEntity<SpecialPickup> updateSpecialPickup(@PathVariable Long pickupId, @RequestBody SpecialPickup specialPickupDetails) {
        SpecialPickup updatedPickup = specialPickupService.updateSpecialPickup(pickupId, specialPickupDetails);
        if (updatedPickup != null) {
            return new ResponseEntity<>(updatedPickup, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{pickupId}")
    public ResponseEntity<Void> deleteSpecialPickup(@PathVariable Long pickupId) {
        specialPickupService.deleteSpecialPickup(pickupId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

	
	
