package com.odoo.combat.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odoo.combat.entities.SpecialPickup;
import com.odoo.combat.entities.Users;
import com.odoo.combat.repositories.SpecialPickupRepository;
import com.odoo.combat.services.SpecialPickupService;

@Service
public class SpecialPickupServiceImpl implements SpecialPickupService {

	   @Autowired
	    private SpecialPickupRepository specialPickupRepository;

	    @Override
	    public SpecialPickup createSpecialPickup(SpecialPickup specialPickup) {
	        return specialPickupRepository.save(specialPickup);
	    }

	    @Override
	    public SpecialPickup getSpecialPickupById(Long pickupId) {
	        return specialPickupRepository.findById(pickupId).orElse(null);
	    }

	    @Override
	    public List<SpecialPickup> getAllSpecialPickups() {
	        return specialPickupRepository.findAll();
	    }

	    @Override
	    public List<SpecialPickup> getSpecialPickupsByUserId(Long userId) {
	        return specialPickupRepository.findByUser(Users.builder().userId(userId).build());
	    }

	    @Override
	    public SpecialPickup updateSpecialPickup(Long pickupId, SpecialPickup specialPickupDetails) {
	        return specialPickupRepository.findById(pickupId).map(specialPickup -> {
	            specialPickup.setDescription(specialPickupDetails.getDescription());
	            specialPickup.setStatus(specialPickupDetails.getStatus());
	            specialPickup.setScheduledAt(specialPickupDetails.getScheduledAt());
	            specialPickup.setCompletedAt(specialPickupDetails.getCompletedAt());
	            specialPickup.setAddress(specialPickupDetails.getAddress());
	            return specialPickupRepository.save(specialPickup);
	        }).orElse(null);
	    }

	    @Override
	    public void deleteSpecialPickup(Long pickupId) {
	        specialPickupRepository.deleteById(pickupId);
	    }
}
