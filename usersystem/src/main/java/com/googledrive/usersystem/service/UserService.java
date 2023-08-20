package com.googledrive.usersystem.service;

import java.util.List;

import com.googledrive.usersystem.model.User;

public interface UserService {
    public User saveUser(User user);
    public List<User> getallUsers();
    public User loadUserbyEmailAndPassword(String email,String password);
    public User loadUserByEmail(String email);
    public void updateUser(String email, String password);
}
