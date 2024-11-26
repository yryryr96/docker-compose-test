package com.example.demo.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserCreate {

    private final String email;
    private final String password;
    private final String nickname;
    private final String address;
}
