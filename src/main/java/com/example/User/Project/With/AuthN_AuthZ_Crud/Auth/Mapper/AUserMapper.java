package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Mapper;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Dto.AUserDto;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Entity.AUser;

public class AUserMapper {
    public static AUserDto EntityToDto(AUser aUser){
        return new AUserDto(
                aUser.getUserName(),
                aUser.getEmail(),
                aUser.getPassword(),
                aUser.getRole()
        );
    }

    public static AUser DtoToEntity(AUserDto aUserDto){
        AUser aUser =  new AUser();
        aUser.setUserName(aUserDto.getUserName());
        aUser.setEmail(aUserDto.getEmail());
        aUser.setPassword(aUserDto.getPassword());
        aUser.setRole(aUserDto.getRole());
        return aUser;
    }
}
