package com.example.demo.user.controller;

import com.example.demo.user.controller.port.UserService;
import com.example.demo.user.controller.response.UserResponse;
import com.example.demo.user.domain.UserCreate;
import com.example.demo.user.service.CertificationService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserCreateController {

    private final UserService userService;
    private final CertificationService certificationService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserCreate userCreate) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserResponse.from(userService.create(userCreate)));
    }

    @GetMapping("/send")
    public ResponseEntity<String> send(@RequestParam String email) {
        return ResponseEntity
                .ok()
                .body(certificationService.send(email));
    }

    @GetMapping("/certify")
    public ResponseEntity<String> certify(@RequestParam String email, @RequestParam String certificationNumber) {
        return ResponseEntity
                .ok()
                .body(certificationService.certify(email, certificationNumber));
    }

}
