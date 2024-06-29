package com.odoo.combat.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.odoo.combat.entities.Reports;
import com.odoo.combat.entities.Users;
import com.odoo.combat.entities.constants.ReportStatus;
import com.odoo.combat.services.ReportsService;
import com.odoo.combat.utils.impl.Storage;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportsController {

    @Autowired
    private ReportsService reportsService;

    @GetMapping
    public ResponseEntity<List<Reports>> getAllReports() {
        List<Reports> reports = reportsService.getAllReports();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<Reports> getReportById(@PathVariable Integer reportId) {
        Reports report = reportsService.getReportById(reportId);
        if (report != null) {
            return new ResponseEntity<>(report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Reports> createReport(@RequestPart("report") Reports report, @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
      
        Reports savedReport = reportsService.createReport(report, image);
        return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
    }

    @PutMapping("/{reportId}")
    public ResponseEntity<Reports> updateReport(@PathVariable Integer reportId, @RequestBody Reports report) {
        report.setReportId(reportId); // Ensure report ID matches path variable
        Reports updatedReport = reportsService.updateReport(report);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> deleteReport(@PathVariable Integer reportId) {
        reportsService.deleteReport(reportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Reports>> getReportsByUser(@PathVariable Long userId) {
        Users user = new Users();  // Assuming you can construct a Users object with ID
        user.setUserId(userId);
        List<Reports> reports = reportsService.getReportsByUser(user);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/byStatus/{status}")
    public ResponseEntity<List<Reports>> getReportsByStatus(@PathVariable ReportStatus status) {
        List<Reports> reports = reportsService.getReportsByStatus(status);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}

