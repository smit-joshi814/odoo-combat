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
import org.springframework.web.bind.annotation.RestController;

import com.odoo.combat.entities.Schedules;
import com.odoo.combat.services.SchedulesService;

@RestController
@RequestMapping("/api/v1/schedules")
public class SchedulesController {

    @Autowired
    private SchedulesService schedulesService;

    @GetMapping
    public ResponseEntity<List<Schedules>> getAllSchedules() {
        List<Schedules> schedules = schedulesService.getAllSchedules();
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<Schedules> getScheduleById(@PathVariable Integer scheduleId) {
        Schedules schedule = schedulesService.getScheduleById(scheduleId);
        if (schedule != null) {
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Schedules> createSchedule(@RequestBody Schedules schedule) {
        Schedules savedSchedule = schedulesService.createSchedule(schedule);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<Schedules> updateSchedule(@PathVariable Integer scheduleId, @RequestBody Schedules schedule) {
        schedule.setScheduleId(scheduleId); // Ensure schedule ID matches path variable
        Schedules updatedSchedule = schedulesService.updateSchedule(schedule);
        return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer scheduleId) {
        schedulesService.deleteSchedule(scheduleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Implement additional methods based on your needs (e.g., filtering by date)
}
