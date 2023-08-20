package com.googledrive.usersystem.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.googledrive.usersystem.model.User;
import com.googledrive.usersystem.repository.UserRepository;

@Qualifier("user")
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getallUsers(){
        return userRepository.findAll();
    }

    @Override
    public User loadUserbyEmailAndPassword(String email,String password){
        return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User loadUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public void updateUser(String email, String password){
        User user = userRepository.findByEmail(email);
        user.setPassword(password);
        userRepository.save(user);
    }
    
}
