package com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Service;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Dto.CUserDto;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Entity.CUser;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Exception.CUserException;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Mapper.CUserMapper;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Repository.CUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CUserServiceImpl implements CUserService{

    public final CUserRepository cUserRepository;

    @Override
    public CUserDto createUser(CUserDto cUserDto) {
        CUser cUser = CUserMapper.DtoToEntity(cUserDto);
        CUser saved = cUserRepository.save(cUser);
        return CUserMapper.EntityToDto(saved);
    }

    @Override
    public CUserDto getUserById(Long id) {
        CUser cUser = cUserRepository.findById(id).orElseThrow(()->
                new CUserException("User is not found at Given Id : " + id));
        return CUserMapper.EntityToDto(cUser);
    }

    @Override
    public List<CUserDto> getAllUser() {
        List<CUser> users = cUserRepository.findAll();
        return users.stream().map((user)-> CUserMapper.EntityToDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public CUserDto updateUser(CUserDto cUserDto, Long id) {
        CUser cUser = cUserRepository.findById(id).orElseThrow(()->
                new CUserException("User is not found at the given Id : " + id));
        cUser.setId(cUserDto.getId());
        cUser.setUserName(cUserDto.getUserName());
        cUser.setEmail(cUserDto.getEmail());
        cUser.setPassword(cUserDto.getPassword());
        return CUserMapper.EntityToDto(cUser);
    }

    @Override
    public void deleteUser(Long id) {
        CUser cUser = cUserRepository.findById(id).orElseThrow(()->
                new CUserException("User is not found at the given Id : " + id));
        cUserRepository.deleteById(id);
    }
}
