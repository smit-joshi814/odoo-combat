package com.odoo.combat.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.odoo.combat.config.auth.AuthUserDetails;
import com.odoo.combat.entities.Users;
import com.odoo.combat.services.UserService;


public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userService.getUser(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid Username Or Password");
		}

		return new AuthUserDetails(user);
	}
}