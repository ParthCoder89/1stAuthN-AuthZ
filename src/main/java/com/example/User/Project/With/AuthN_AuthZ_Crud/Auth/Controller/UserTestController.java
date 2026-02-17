package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTestController {
    @GetMapping("/api/secure")
    public String secure(){
        return "Jwt Authenticated Api";
    }
}
