package com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Repository;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Auth.Entity.AUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AUserRepository extends JpaRepository<AUser, Long> {
     Optional<AUser> findByUserName(String userName);
}
