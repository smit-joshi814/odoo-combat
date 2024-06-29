package com.odoo.combat.services;

import java.util.List;

import com.odoo.combat.entities.Schedules;

public interface SchedulesService {

	   List<Schedules> getAllSchedules();

	    Schedules getScheduleById(Integer scheduleId);

	    Schedules createSchedule(Schedules schedule);

	    Schedules updateSchedule(Schedules schedule);

	    void deleteSchedule(Integer scheduleId);
}
