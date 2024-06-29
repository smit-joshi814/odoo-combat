package com.odoo.combat.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.odoo.combat.entities.Schedules;
import com.odoo.combat.services.ReportsService;
import com.odoo.combat.services.SchedulesService;
import com.odoo.combat.services.SpecialPickupService;
import com.odoo.combat.services.TasksService;

@Controller
public class DashboardController {

	@Autowired
	private SchedulesService schedulesService;

	@Autowired
	private ReportsService reportsService;

	@Autowired
	private SpecialPickupService pickupService;

	@Autowired
	private TasksService tasksService;

	@GetMapping
	public String root() {
		return "redirect:/home";
	}

	@GetMapping("home")
	public ModelAndView home(ModelAndView mv) {
		mv.addObject("schedules", schedulesService.getAllSchedules());
		mv.addObject("reports", reportsService.getAllReports());
		mv.addObject("pickups", pickupService.getAllSpecialPickups());
		mv.addObject("tasks", tasksService.getAllTasks());
		mv.setViewName("index");
		return mv;
	}

	@PostMapping("/add-schedule")
	public String addSchedule(@RequestParam("day") String day, @RequestParam("time") LocalDateTime time,
			@RequestParam("area") String area) {
		System.out.println("Okkkkkkkkkkkkkkk" + time.toString());
		schedulesService.createSchedule(Schedules.builder().day(day).time(time).area(area).build());
		return "redirect:/home";
	}

}
