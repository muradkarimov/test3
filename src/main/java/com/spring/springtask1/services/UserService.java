package com.spring.springtask1.services;

import com.spring.springtask1.dao.requests.UserRequest;
import com.spring.springtask1.entities.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User findById(Integer id);
    void deleteById(Integer id);
    User update(User role);
    void create(UserRequest userRequest);
}
