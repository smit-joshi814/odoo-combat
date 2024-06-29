package com.odoo.combat.config.auth.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;


@Component
public class SessionDestroyedEventListener implements ApplicationListener<SessionDestroyedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(SessionDestroyedEventListener.class);

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {

		// Handle session expiration event
		event.getSecurityContexts().forEach(securityContext -> {
			String username = securityContext.getAuthentication().getName();

			logger.info("Session expired for user: {}", username);
			
		});
	}
}