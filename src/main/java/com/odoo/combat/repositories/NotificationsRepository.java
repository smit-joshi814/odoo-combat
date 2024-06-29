package com.odoo.combat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odoo.combat.entities.Notifications;

public interface NotificationsRepository extends JpaRepository<Notifications, Integer>{

	List<Notifications> findByIsRead(boolean b);

}
