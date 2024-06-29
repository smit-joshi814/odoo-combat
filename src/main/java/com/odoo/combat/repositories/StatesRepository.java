package com.odoo.combat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odoo.combat.entities.States;

public interface StatesRepository extends JpaRepository<States, Integer> {

}
