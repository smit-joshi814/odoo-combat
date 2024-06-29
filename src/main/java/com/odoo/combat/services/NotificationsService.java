package com.odoo.combat.services;

import java.util.List;

import com.odoo.combat.entities.Notifications;

public interface NotificationsService {

    List<Notifications> getAllNotifications();

    Notifications getNotificationById(Integer notificationId);

    Notifications createNotification(Notifications notification);

    void markNotificationAsRead(Integer notificationId);

    void deleteNotification(Integer notificationId);

    // Additional methods based on your needs (optional)
    List<Notifications> getUnreadNotifications();
}
