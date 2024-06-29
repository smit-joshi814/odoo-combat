package com.odoo.combat.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odoo.combat.entities.Reports;
import com.odoo.combat.entities.Users;
import com.odoo.combat.entities.constants.ReportStatus;
import com.odoo.combat.repositories.ReportsRepository;
import com.odoo.combat.services.ReportsService;
@Service
public class ReportsServiceImpl implements ReportsService {


    @Autowired
    private ReportsRepository reportsRepository;

    @Override
    public List<Reports> getAllReports() {
        return reportsRepository.findAll();
    }

    @Override
    public Reports getReportById(Integer reportId) {
        Optional<Reports> optionalReport = reportsRepository.findById(reportId);
        return optionalReport.orElse(null);
    }

    @Override
    public Reports createReport(Reports report) {
        return reportsRepository.save(report);
    }

    @Override
    public Reports updateReport(Reports report) {
        return reportsRepository.save(report);
    }

    @Override
    public void deleteReport(Integer reportId) {
        reportsRepository.deleteById(reportId);
    }

    // Implement additional methods based on your needs

    @Override
    public List<Reports> getReportsByUser(Users user) {
        return reportsRepository.findByUser(user);
    }

    @Override
    public List<Reports> getReportsByStatus(ReportStatus status) {
        return reportsRepository.findByStatus(status);
    }

}