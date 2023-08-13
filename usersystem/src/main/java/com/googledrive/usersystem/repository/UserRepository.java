package com.googledrive.usersystem.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.googledrive.usersystem.model.User;

@Qualifier("user")
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    
}
