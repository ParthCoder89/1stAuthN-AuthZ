package com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Repository;

import com.example.User.Project.With.AuthN_AuthZ_Crud.Crud.Entity.CUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CUserRepository extends JpaRepository<CUser, Long> {
}
