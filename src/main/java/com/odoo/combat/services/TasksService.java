package com.odoo.combat.services;

import java.util.List;

import com.odoo.combat.entities.Tasks;


public interface TasksService {

    List<Tasks> getAllTasks();

    Tasks getTaskById(Integer taskId);

    Tasks createTask(Tasks task);

    Tasks updateTask(Tasks task);

    void deleteTask(Integer taskId);

}
