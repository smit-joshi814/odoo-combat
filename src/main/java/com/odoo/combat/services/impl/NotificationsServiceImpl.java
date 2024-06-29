package com.odoo.combat.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odoo.combat.entities.Notifications;
import com.odoo.combat.repositories.NotificationsRepository;
import com.odoo.combat.services.NotificationsService;

@Service
public class NotificationsServiceImpl implements NotificationsService {

	 @Autowired
	    private NotificationsRepository notificationsRepository;

	    @Override
	    public List<Notifications> getAllNotifications() {
	        return notificationsRepository.findAll();
	    }

	    @Override
	    public Notifications getNotificationById(Integer notificationId) {
	        Optional<Notifications> optionalNotification = notificationsRepository.findById(notificationId);
	        return optionalNotification.orElse(null);
	    }

	    @Override
	    public Notifications createNotification(Notifications notification) {
	        return notificationsRepository.save(notification);
	    }

	    @Override
	    public void markNotificationAsRead(Integer notificationId) {
	        Notifications notification = getNotificationById(notificationId);
	        if (notification != null) {
	            notification.setIsRead(true);
	            notificationsRepository.save(notification);
	        }
	    }

	    @Override
	    public void deleteNotification(Integer notificationId) {
	        notificationsRepository.deleteById(notificationId);
	    }

	    @Override
	    public List<Notifications> getUnreadNotifications() {
	        return notificationsRepository.findByIsRead(false);
	    }

}
