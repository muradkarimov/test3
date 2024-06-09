package com.spring.springtask1.services;

import com.spring.springtask1.dao.requests.TaskRequest;
import com.spring.springtask1.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> list();
    void create(TaskRequest taskRequest);
    List<Task> update();
}
