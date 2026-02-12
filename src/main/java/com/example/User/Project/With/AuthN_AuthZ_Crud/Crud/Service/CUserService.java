package com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Service;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Dto.CUserDto;

import java.util.List;

public interface CUserService {
    CUserDto createUser(CUserDto cUserDto);
    CUserDto getUserById(Long id);
    List<CUserDto> getAllUser();
    CUserDto updateUser(CUserDto cUserDto, Long id);
    void deleteUser(Long id);
}
