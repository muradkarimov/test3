package com.spring.springtask1.services.impl;


import com.spring.springtask1.dao.requests.UserRequest;
import com.spring.springtask1.entities.User;
import com.spring.springtask1.repositories.UserRepository;
import com.spring.springtask1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        userRepository.findById(user.getId()).orElseThrow();
        return userRepository.save(user);
    }

    @Override
    public void create(UserRequest userRequest) {
        User user = User.builder().
                userName(userRequest.getUserName()).
                userSurname(userRequest.getUserSurname()).
                userAge(userRequest.getUserAge()).
                build();
        userRepository.save(user);
    }
}
