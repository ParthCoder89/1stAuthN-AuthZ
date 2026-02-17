package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @GetMapping("/test")
    public String adminTest(){
        return "Admin Access Granted";
    }
}
