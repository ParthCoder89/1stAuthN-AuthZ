package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Service;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Entity.AUser;

public interface AUserService {
    AUser saveUser (AUser aUser);
    AUser findUserByName(String userName);
}
