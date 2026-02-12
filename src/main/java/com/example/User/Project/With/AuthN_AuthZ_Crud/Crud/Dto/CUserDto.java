package com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CUserDto {
    private Long id;
    private String userName;
    private String email;
    private String password;
}
