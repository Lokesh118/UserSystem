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
        // String name = user.getName();
        // String email = user.getEmail();
        // String password = user.getPassword();
        // try{
        //     DataSource connection = CloudSqlConnectionPoolFactory.createConnectionPool();
        //     String insertquery = "INSERT INTO User(username,email,password) VALUES (?,?,?)";
        //     PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertquery);
        //     preparedStatement.setString(1,name);
        //     preparedStatement.setString(2,email);
        //     preparedStatement.setString(3,password);
        //     return user;
        // }catch(SQLException e){
        //     e.printStackTrace();
        //     return null;
        // }
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getallUsers(){
        return userRepository.findAll();
    }
    
}
