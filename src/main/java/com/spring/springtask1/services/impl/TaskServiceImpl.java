package com.spring.springtask1.services.impl;

import com.spring.springtask1.dao.requests.TaskRequest;
import com.spring.springtask1.entities.Task;
import com.spring.springtask1.repositories.TaskRepository;
import com.spring.springtask1.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> list() {
        return taskRepository.findAll();
    }

    @Override
    public void create(TaskRequest taskRequest) {
        Task task = Task.builder()
                .descriptiom(taskRequest.getDescriptiom())
                .taskStatus(taskRequest.getTaskStatus())
                .taskPriority(taskRequest.getTaskPriority())
                .deadline(taskRequest.getDeadline())
                .build();
        taskRepository.save(task);
    }

    @Override
    public List<Task> update() {
        return null;
    }
}
