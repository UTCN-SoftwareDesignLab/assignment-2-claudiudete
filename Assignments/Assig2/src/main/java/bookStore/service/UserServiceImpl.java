package bookStore.service;

import bookStore.dto.UserDto;
import bookStore.entity.User;
import bookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;

    }

    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    public void deleteByUsername(String username)
    {
        userRepository.deleteByUsername(username);
    }

    public void saveUser(UserDto user)
    {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        User u=new User(user.getUsername(),passwordEncoder.encode(user.getPassword()),user.getRole());
        userRepository.save(u);
    }

    public void updateUser(UserDto user)
    {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        userRepository.updateUser(passwordEncoder.encode(user.getPassword()),user.getRole(),user.getUsername());
    }














}
