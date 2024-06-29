package com.odoo.combat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odoo.combat.entities.Cities;
import com.odoo.combat.entities.States;

public interface CitiesRepository extends JpaRepository<Cities, Integer>{

	List<Cities> findByState(States state);

}
