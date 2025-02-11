package org.example.rabbitmq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloController {
    @GetMapping("")
    public String helo() {
        return "hello";
    }
}
