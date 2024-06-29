package com.odoo.combat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

	@GetMapping("/sign-in")
	public ModelAndView signIn(ModelAndView mv) {
		mv.setViewName("sign-in");
		return mv;
	}
	
	@GetMapping("/sign-up")
	public ModelAndView signUp(ModelAndView mv) {
		mv.setViewName("sign-up");
		return mv;
	}

}
