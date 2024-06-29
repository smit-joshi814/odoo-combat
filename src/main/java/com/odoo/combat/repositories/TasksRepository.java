package com.odoo.combat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odoo.combat.entities.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Integer> {

}
