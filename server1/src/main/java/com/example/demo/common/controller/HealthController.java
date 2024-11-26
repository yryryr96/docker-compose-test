package com.example.demo.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "server is running!!!";
    }

    @GetMapping("/health-v")
    public String healthVersion() {
        return "this is version3";
    }
}
