package com.odoo.combat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odoo.combat.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
