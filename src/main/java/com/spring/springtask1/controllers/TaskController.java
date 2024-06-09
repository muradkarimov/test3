package com.spring.springtask1.controllers;

import com.spring.springtask1.dao.requests.TaskRequest;
import com.spring.springtask1.entities.Task;
import com.spring.springtask1.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<Task> list(){
        return taskService.list();
    }

    @PostMapping("/")
    public void create(TaskRequest taskRequest){
        taskService.create(taskRequest);
    }
}
