package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AUserDto {
    private String userName;
    private String email;
    private String password;
    private String role;
}
