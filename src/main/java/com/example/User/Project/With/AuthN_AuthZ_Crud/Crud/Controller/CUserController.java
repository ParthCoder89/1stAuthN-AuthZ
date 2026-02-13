package com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Controller;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Dto.CUserDto;
import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Service.CUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud")
@RequiredArgsConstructor
public class CUserController {

    private final CUserService cUserService;

    @PostMapping
    public ResponseEntity<CUserDto> create(@RequestBody CUserDto cUserDto){
        CUserDto user = cUserService.createUser(cUserDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CUserDto> getUser(@PathVariable("id") Long id){
        CUserDto user = cUserService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CUserDto>> getAllUser(){
        List<CUserDto> users = cUserService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CUserDto> update(@RequestBody CUserDto cUserDto, @PathVariable("id") Long id){
        CUserDto user = cUserService.updateUser(cUserDto, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        cUserService.deleteUser(id);
        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }


}
