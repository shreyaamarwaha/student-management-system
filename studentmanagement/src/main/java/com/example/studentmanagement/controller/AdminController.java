package com.example.studentmanagement.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/update-record")
    public String updateSomething() {
        return "Record updated by ADMIN";
    }
}
