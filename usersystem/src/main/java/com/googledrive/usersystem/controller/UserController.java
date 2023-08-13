package com.googledrive.usersystem.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

// import org.checkerframework.common.reflection.qual.GetClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

// import com.google.auth.oauth2.GoogleCredentials;
// import com.google.auth.oauth2.ServiceAccountCredentials;
import com.googledrive.usersystem.model.User;
import com.googledrive.usersystem.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Qualifier("user")
@RestController
@RequestMapping("/auth/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/v2/register")
    public ResponseEntity<String> registerV2(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<String> ("user registration done", HttpStatus.CREATED);
    }

    @PostMapping("/v2/login")
    public ResponseEntity<String> loginV2(@RequestBody User user){
        List<User> users = userService.getallUsers();
        for(User userelement : users){
            String temp = user.getName() + " " + user.getEmail() + " " + user.getPassword();
            String temp2 = userelement.getName() + " " + userelement.getEmail() + " " + userelement.getPassword();
            System.out.println(temp + "\n");
            System.out.println(temp2 + "\n");
            if(temp.equals(temp2)){
                return new ResponseEntity<String>("Login Success", HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
    }
    // private JdbcTemplate jdbcTemplate;
    // public UserController(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate = jdbcTemplate;
    // }
    // @PostMapping("/register")
    // public ResponseEntity<String> register(@RequestBody User user) throws IOException{
    //     String name = user.getName();
    //     String email = user.getEmail();
    //     String password = user.getPassword();
    //     String reEnteredPassword = user.getReEnteredPassword();
    //     if(password != reEnteredPassword){
    //         return new ResponseEntity<String>("passwords didn't match", HttpStatus.BAD_REQUEST);
    //     }
    //     String resp = name+email+password;
    //     try{
    //         DataSource connection = CloudSqlConnectionPoolFactory.createConnectionPool();
    //         String insertquery = "INSERT INTO users(username,email,password) VALUES (?,?,?)";
    //         PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertquery);
    //         preparedStatement.setString(1,name);
    //         preparedStatement.setString(2,email);
    //         preparedStatement.setString(3,password);
    //         preparedStatement.executeUpdate();
    //         return new ResponseEntity<>(resp + "Successfully Registered", HttpStatus.OK);
    //     }catch(SQLException e){
    //         e.printStackTrace();
    //         return new ResponseEntity<>("Registration failed",HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
    // @PostMapping("/register2")
    // public ResponseEntity<String> register2(@Qualifier("user") User user){
    //     String name = user.getName();
    //     String email = user.getEmail();
    //     String password = user.getPassword();
    //     String sql = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
    //     jdbcTemplate.update(sql,name,email,password);
        
    //     return new ResponseEntity<String>("user registration done",HttpStatus.OK);
    // }

    @GetMapping("/allusers")
    public List<String> getallusers(){
        List<User> users = userService.getallUsers();
        List<String> res = new ArrayList<String>();
        for(User user:users){
            String temp = user.getName() + " " + user.getEmail() + " " + user.getPassword();
            res.add(temp);
        }
        return res;
    }
    // @Autowired
    // @PostMapping("/login")
    // public ResponseEntity<String> login(@RequestBody User user){
    //     String name = user.getName();
    //     String email = user.getEmail();
    //     String password = user.getPassword();
    //     System.out.println(name + email + password);
    //     try{
    //         DataSource connection = CloudSqlConnectionPoolFactory.createConnectionPool();
    //         ResultSet rs = connection.getConnection().prepareStatement("select * from users").executeQuery();
    //         String id = "";
    //         while(rs.next()){
    //             String idd = rs.getString(1);
    //             String name1 = rs.getString(2);
    //             String email1 = rs.getString(3);
    //             String password1 = rs.getString(4);
    //             System.out.println(idd+name1+email1+password1);
    //             if(name1 == name && email1 == email && password1 == password){
    //                 id = idd;
    //                 break;
    //             }
    //         }
    //         System.out.println(id);
    //         if(id.length() == 0) return new ResponseEntity<>("User doesn't exist", HttpStatus.NOT_FOUND);
    //         else return new ResponseEntity<>(id, HttpStatus.OK);
    //     }catch(SQLException e){
    //         e.printStackTrace();
    //         return new ResponseEntity<>("Login Failed",HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
}
