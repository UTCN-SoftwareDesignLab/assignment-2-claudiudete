package bookStore.service;

import bookStore.entity.User;

import java.security.MessageDigest;
import java.util.List;

public interface AuthenticationService {

    List<User> findByUsernameAndPassword(String username, String password);



}
