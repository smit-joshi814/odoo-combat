package com.odoo.combat.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odoo.combat.entities.Schedules;
import com.odoo.combat.repositories.SchedulesRepository;
import com.odoo.combat.services.SchedulesService;

@Service
public class SchedulesServiceImpl implements SchedulesService{
	@Autowired
    private SchedulesRepository schedulesRepository;

    @Override
    public List<Schedules> getAllSchedules() {
        return schedulesRepository.findAll();
    }

    @Override
    public Schedules getScheduleById(Integer scheduleId) {
        Optional<Schedules> optionalSchedule = schedulesRepository.findById(scheduleId);
        return optionalSchedule.orElse(null);
    }

    @Override
    public Schedules createSchedule(Schedules schedule) {
        return schedulesRepository.save(schedule);
    }

    @Override
    public Schedules updateSchedule(Schedules schedule) {
        return schedulesRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Integer scheduleId) {
        schedulesRepository.deleteById(scheduleId);
    }
}
