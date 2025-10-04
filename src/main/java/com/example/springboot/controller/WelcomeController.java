package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Welcome Controller
 * Handles basic welcome endpoint
 */
@RestController
public class WelcomeController {

    /**
     * Welcome endpoint
     * GET /
     */
    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Boot Demo Application!";
    }

    /**
     * Health check endpoint
     * GET /health
     */
    @GetMapping("/health")
    public String health() {
        return "Application is running!";
    }
}
