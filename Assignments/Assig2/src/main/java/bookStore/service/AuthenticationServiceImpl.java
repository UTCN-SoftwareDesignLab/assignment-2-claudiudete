package bookStore.service;

import bookStore.entity.User;
import bookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private UserRepository userRepository;


    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public List<User> findByUsernameAndPassword(String username, String password)
    {
        return userRepository.findByUsernameAndPassword(username,encodePassword(password));
    }

    private String encodePassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            return null;
        }
    }


}
