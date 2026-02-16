package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Controller;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Dto.AUserDto;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Entity.AUser;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Exception.AUserException;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Mapper.AUserMapper;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Security.AJwtUtil;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Service.AUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/**")
@RequiredArgsConstructor
public class AUserController {

    private final AUserService aUserService;
    private final PasswordEncoder passwordEncoder;
    private final AJwtUtil aJwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> saveUser(@RequestBody AUserDto aUserDto){
        AUser aUser = AUserMapper.DtoToEntity(aUserDto);
        aUser.setPassword(passwordEncoder.encode(aUserDto.getPassword()));
        aUserService.saveUser(aUser);
        return new ResponseEntity<>("User Detail Successfully Added", HttpStatus.OK);
    }

    @PostMapping("/login")
    public String findUser(@RequestBody AUserDto aUserDto){
        AUser aUser = aUserService.findUserByName(aUserDto.getUserName());
        if(aUser == null){
            throw new AUserException("User Not Found");
        }
        if(!passwordEncoder.matches(aUserDto.getPassword(), aUser.getPassword())){
            throw new AUserException("Wrong Password");
        }
        return aJwtUtil.generateToken(aUser.getUserName(), aUser.getRole());
    }

}
