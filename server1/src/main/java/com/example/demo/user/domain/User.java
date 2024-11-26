package com.example.demo.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private final Long id;
    private final String email;
    private final String password;
    private final String nickname;
    private final String address;
    private final UserStatus status;
    private final Long lastLoginAt;

    @Builder
    public User(Long id, String email, String password, String nickname, String address, UserStatus status, Long lastLoginAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.address = address;
        this.status = status;
        this.lastLoginAt = lastLoginAt;
    }

    public static User from(UserCreate userCreate) {
        return User.builder()
                .email(userCreate.getEmail())
                .nickname(userCreate.getNickname())
                .password(userCreate.getPassword())
                .status(UserStatus.PENDING)
                .address(userCreate.getEmail())
                .build();
    }
}
