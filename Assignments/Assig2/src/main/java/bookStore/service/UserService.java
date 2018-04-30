package bookStore.service;

import bookStore.dto.UserDto;
import bookStore.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void deleteByUsername(String username);
    void saveUser(UserDto user);
    void updateUser(UserDto user);



}
