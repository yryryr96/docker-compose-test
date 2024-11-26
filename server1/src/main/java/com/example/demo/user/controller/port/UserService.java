package com.example.demo.user.controller.port;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserCreate;
import com.example.demo.user.domain.UserUpdate;

public interface UserService {

    User getByEmail(String email);
    User getById(Long id);
    User create(UserCreate userCreate);
    User update(UserUpdate userUpdate);
    User login(long id);
}
