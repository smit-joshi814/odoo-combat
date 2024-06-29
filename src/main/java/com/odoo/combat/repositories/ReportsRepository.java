package com.odoo.combat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odoo.combat.entities.Reports;
import com.odoo.combat.entities.Users;
import com.odoo.combat.entities.constants.ReportStatus;

public interface ReportsRepository extends JpaRepository<Reports,Integer >  {

	List<Reports> findByUser(Users user);

	List<Reports> findByStatus(ReportStatus status);

}
