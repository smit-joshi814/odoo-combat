package com.odoo.combat.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.odoo.combat.entities.Reports;
import com.odoo.combat.entities.Users;
import com.odoo.combat.entities.constants.ReportStatus;
import com.odoo.combat.repositories.ReportsRepository;
import com.odoo.combat.services.ReportsService;
import com.odoo.combat.services.StorageService;
import com.odoo.combat.utils.impl.Storage;
@Service
public class ReportsServiceImpl implements ReportsService {


    @Autowired
    private ReportsRepository reportsRepository;
    
    @Autowired
    private StorageService storage;

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
    public Reports createReport(Reports report,MultipartFile image) {
    	try {
			String url = storage.upload(image, image.getName(), Storage.STORAGE_ODOO);
			report.setPhotoURL(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
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