package com.odoo.combat.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odoo.combat.entities.Tasks;
import com.odoo.combat.repositories.TasksRepository;
import com.odoo.combat.services.TasksService;

@Service
public class TaskServiceImpl implements TasksService{

    @Autowired
    private TasksRepository taskRepository;

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Tasks getTaskById(Integer taskId) {
        Optional<Tasks> optionalTask = taskRepository.findById(taskId);
        return optionalTask.orElse(null);
    }

    @Override
    public Tasks createTask(Tasks task) {
        return taskRepository.save(task);
    }

    @Override
    public Tasks updateTask(Tasks task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer taskId) {
        taskRepository.deleteById(taskId);
    }


 }
