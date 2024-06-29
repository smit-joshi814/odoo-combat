package com.odoo.combat.services;

import java.util.List;

import com.odoo.combat.entities.Reports;
import com.odoo.combat.entities.Users;
import com.odoo.combat.entities.constants.ReportStatus;

public interface ReportsService {	

    List<Reports> getAllReports();

    Reports getReportById(Integer reportId);

    Reports createReport(Reports report);

    Reports updateReport(Reports report);

    void deleteReport(Integer reportId);

    // Additional methods based on your needs (optional)
    List<Reports> getReportsByUser(Users user);
    List<Reports> getReportsByStatus(ReportStatus status);
}
