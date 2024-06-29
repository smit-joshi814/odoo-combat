package com.odoo.combat.config.auth.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class LogoutSuccessEventListener implements ApplicationListener<LogoutSuccessEvent> {

	private static final Logger logger = LoggerFactory.getLogger(LogoutSuccessEventListener.class);

	@Override
	public void onApplicationEvent(LogoutSuccessEvent event) {
		// Handle successful logout event
		String username = event.getAuthentication().getName();

		logger.info("User logged out: {} ", username);
	}
}