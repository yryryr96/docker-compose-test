package com.example.demo.user.service;

import com.example.demo.user.controller.port.UserService;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserCreate;
import com.example.demo.user.domain.UserUpdate;
import com.example.demo.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CertificationService certificationService;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User update(UserUpdate userUpdate) {
        return null;
    }

    @Override
    public User login(long id) {
        return null;
    }

    @Override
    @Transactional
    public User create(UserCreate userCreate) {

        // UserCreate -> User
        User user = User.from(userCreate);
        return userRepository.save(user);
    }
}
