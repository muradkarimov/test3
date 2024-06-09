package com.spring.springtask1.dao.requests;

import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String userSurname;
    private Integer userAge;
}
