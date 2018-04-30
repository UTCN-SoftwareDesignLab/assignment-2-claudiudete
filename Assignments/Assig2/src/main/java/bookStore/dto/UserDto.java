package bookStore.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

    @Size(min = 5 ,message = "Username too short")
    private String username;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain 8 characters" +
            "one uppercase and one special symbol")
    private String password;

    @Pattern(regexp = "^(administrator|user)$", message = "Role must be administrator or user")
    private String role;



    public UserDto()
    {

    }

    public UserDto(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
