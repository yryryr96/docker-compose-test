package com.example.demo.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserUpdate {

    private final String nickname;
    private final String address;
}
