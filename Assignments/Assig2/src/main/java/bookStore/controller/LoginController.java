package bookStore.controller;

import bookStore.entity.User;
import bookStore.service.AuthenticationService;
import bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class LoginController {

    private AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService)
    {
        this.authenticationService=authenticationService;
    }


    @GetMapping("/login")
    @Order(value = 1)
    public String displayLogin()
    {
      return "login";
    }

  /*  @RequestMapping(value="/login", method=RequestMethod.POST)
   public String login(@RequestParam("username") String username,@RequestParam("password") String password)
    {

        List<User> users=authenticationService.findByUsernameAndPassword(username,password);
        if(users.size()!=0)
        {

          if(users.get(0).getRole()=="Administrator")
          {
              return "userView";
          }
          else
          {
              return "userView";
          }
        }
        else
            return "userView";
    }*/





}
