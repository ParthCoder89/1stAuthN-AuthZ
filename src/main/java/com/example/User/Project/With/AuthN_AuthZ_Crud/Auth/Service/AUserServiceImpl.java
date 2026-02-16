package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Service;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Entity.AUser;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Exception.AUserException;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Repository.AUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AUserServiceImpl implements AUserService{

    private final AUserRepository aUserRepository;

    @Override
    public AUser saveUser(AUser aUser) {
        if(aUser.getRole() == null){
            aUser.setRole("ROLE_USER");
        }
        return aUserRepository.save(aUser);
    }

    @Override
    public AUser findUserByName(String userName) {
        return aUserRepository.findByUserName(userName).orElse(null);
    }
}
