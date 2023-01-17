package com.mupra.task.controller;

import com.mupra.task.dto.AdminDto;
import com.mupra.task.entity.Admin;
import com.mupra.task.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/signUp")
public class SignUpController {
    private final AdminService adminService;

    public SignUpController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping
    public Admin signUp(@RequestBody AdminDto adminDto){
        return adminService.signUp(adminDto.getUsername(), adminDto.getPassword());
    }
}
