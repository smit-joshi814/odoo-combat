package com.odoo.combat.services;

import java.util.List;

import com.odoo.combat.entities.SpecialPickup;

public interface SpecialPickupService {
	SpecialPickup createSpecialPickup(SpecialPickup specialPickup);

	SpecialPickup getSpecialPickupById(Long pickupId);

	List<SpecialPickup> getAllSpecialPickups();

	List<SpecialPickup> getSpecialPickupsByUserId(Long userId);

	SpecialPickup updateSpecialPickup(Long pickupId, SpecialPickup specialPickupDetails);

	void deleteSpecialPickup(Long pickupId);
}
