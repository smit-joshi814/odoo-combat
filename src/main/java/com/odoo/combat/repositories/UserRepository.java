package com.odoo.combat.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odoo.combat.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String username);

}
	