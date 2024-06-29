package com.odoo.combat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odoo.combat.entities.SpecialPickup;
import com.odoo.combat.entities.Users;

import java.util.List;


public interface SpecialPickupRepository extends JpaRepository<SpecialPickup, Long>{
 List<SpecialPickup> findByUser(Users user);
}
