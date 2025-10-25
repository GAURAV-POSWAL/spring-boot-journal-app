package com.teamSpring.JournalApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check-health")
public class HealthCheckup {

    @GetMapping
    public String check() {
        return "Application is running!";
    }
}
