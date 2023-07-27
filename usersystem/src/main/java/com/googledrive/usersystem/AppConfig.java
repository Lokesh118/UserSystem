package com.googledrive.usersystem;

import com.googledrive.usersystem.model.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public User user(){
        return new User();
    }
}
