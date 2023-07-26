package com.googledrive.usersystem.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.googledrive.usersystem.model.User;

@RestController
@RequestMapping("/auth/v1/")
public class UserController {
    @Autowired
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody(required = true) User user){
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        try{
            DataSource connection = CloudSqlConnectionPoolFactory.createConnectionPool();
            String insertquery = "INSERT INTO users(username,email,password) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertquery);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            return new ResponseEntity<>("User Successfully Registered", HttpStatus.OK);
        }catch(SQLException e){
            e.printStackTrace();
            return new ResponseEntity<>("Registration failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Autowired
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody(required = true) User user){
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        try{
            DataSource connection = CloudSqlConnectionPoolFactory.createConnectionPool();
            ResultSet rs = connection.getConnection().prepareStatement("select * from users").executeQuery();
            String id = "";
            while(rs.next()){
                if(rs.getString(2) == name && rs.getString(3) == email && rs.getString(4) == password){
                    id = rs.getString(1);
                    break;
                }
            }
            if(id.length() == 0) return new ResponseEntity<>("User doesn't exist", HttpStatus.NOT_FOUND);
            else return new ResponseEntity<>(id, HttpStatus.OK);
        }catch(SQLException e){
            e.printStackTrace();
            return new ResponseEntity<>("Login Failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
