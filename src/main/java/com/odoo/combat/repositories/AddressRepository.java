package com.odoo.combat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odoo.combat.entities.Address;
import com.odoo.combat.entities.Cities;

public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findByCity(Cities city);

}
