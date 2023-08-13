package com.googledrive.usersystem.service;

import java.util.List;

import com.googledrive.usersystem.model.User;

public interface UserService {
    public User saveUser(User user);
    public List<User> getallUsers();
}
