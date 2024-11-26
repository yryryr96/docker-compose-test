package com.example.demo.user.service.port;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserStatus;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

    Optional<User> findByIdAndStatus(Long id, UserStatus status);

    Optional<User> findByEmailAndStatus(String email, UserStatus status);

    User save(User user);

    User getById(Long id);
}
