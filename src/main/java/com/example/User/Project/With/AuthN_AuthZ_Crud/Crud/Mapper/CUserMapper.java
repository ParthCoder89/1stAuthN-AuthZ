package com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Mapper;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Dto.CUserDto;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Entity.CUser;

public class CUserMapper {
    public static CUser DtoToEntity(CUserDto cUserDto){
        return new CUser(
                cUserDto.getId(),
                cUserDto.getUserName(),
                cUserDto.getEmail(),
                cUserDto.getPassword()
        );
    }

    public static CUserDto EntityToDto(CUser cUser){
        return new CUserDto(
                cUser.getId(),
                cUser.getUserName(),
                cUser.getEmail(),
                cUser.getPassword()
        );
    }
}
