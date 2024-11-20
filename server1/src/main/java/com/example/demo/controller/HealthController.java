package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @Autowired
    Environment env;

    @GetMapping("/health")
    public String health() {

        String[] profiles = env.getActiveProfiles();
        for (String profile : profiles) {
            System.out.println("profile = " + profile);
        }

        return "server1 is running!!!";
    }

    @GetMapping("/health-v")
    public String healthVersion() {
        return "this is version2";
    }
}
