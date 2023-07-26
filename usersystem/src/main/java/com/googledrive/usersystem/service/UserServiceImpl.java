package com.googledrive.usersystem.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.googledrive.usersystem.controller.CloudSqlConnectionPoolFactory;
import com.googledrive.usersystem.model.User;

public class UserServiceImpl implements UserService{
    @Override
    public User saveUser(User user){
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        try{
            DataSource connection = CloudSqlConnectionPoolFactory.createConnectionPool();
            String insertquery = "INSERT INTO User(username,email,password) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertquery);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            return user;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
}
