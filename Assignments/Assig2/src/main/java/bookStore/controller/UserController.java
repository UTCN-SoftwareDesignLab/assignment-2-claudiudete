package bookStore.controller;


import bookStore.dto.BookDto;
import bookStore.dto.UserDto;
import bookStore.entity.Book;
import bookStore.entity.User;
import bookStore.service.BookService;
import bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private BookService bookService;


    @Autowired
    public UserController(UserService userService,BookService bookService)
    {
        this.userService=userService;
        this.bookService=bookService;
    }


    @GetMapping("/administratorView")
    public String showView()
    {
        return "administratorView";
    }

    @PostMapping("/createUser")
    public String showCreateUser(Model model)
    {
        model.addAttribute("userDto",new UserDto());
        return "createUser";
    }

    @PostMapping("/deleteUser")
    public String showDeleteUser(Model model)
    {
        model.addAttribute("user",new UserDto());
        model.addAttribute("userLst",userService.findAll());
        return "deleteUser";
    }

    @PostMapping("/updateUser")
    public String showUpdateUser(Model model)
    {
        model.addAttribute("userDto",new UserDto());
        model.addAttribute("userLst",userService.findAll());
        return "updateUser";
    }

    @PostMapping("/findUsers")
    public ModelAndView showUsers()
    {
       List<User> users =userService.findAll();
       ModelAndView modelAndView=new ModelAndView("showUsers");
       modelAndView.addObject("userList",users);
       return modelAndView;

    }

    @PostMapping("/crtUser")
    public String createUser(@Valid UserDto userDto,BindingResult bindingResult)
    {
       if(bindingResult.hasErrors())
       {
           return "createUser";

       }
       else
       {
           userService.saveUser(userDto);
           return "successAdmin";
       }
    }

    @PostMapping("delUser")
    public ModelAndView deleteUser(@ModelAttribute("username") String username) {
        userService.deleteByUsername(username);
        List<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("showUsers");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @PostMapping("updUser")
    public String updateUser(@Valid UserDto userDto,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "updateUser";
        }
        else
        {
            userService.updateUser(userDto);
            return "successAdmin";
        }
    }

    @PostMapping("createBook")
    public String showCreateBook(Model model)
    {
        model.addAttribute("bookDto",new BookDto());
        return "createBook";
    }

    @PostMapping("updateBook")
    public String showUpdateBook(Model model)
    {
        model.addAttribute("bookDto",new BookDto());
        model.addAttribute("bookLst",bookService.findAll());
        return "updateBook";
    }

    @PostMapping("deleteBook")
    public String showDeleteBook(Model model)
    {
        model.addAttribute("bookDto",new BookDto());
        model.addAttribute("bookLst",bookService.findAll());
        return "deleteBook";
    }
    @PostMapping("delBook")
    public ModelAndView deleteBook(@ModelAttribute("name") String name)
    {
        bookService.removeByName(name);
        List<Book> books=bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("showBooks");
        modelAndView.addObject("bookList", books);
        return modelAndView;

    }

    @PostMapping("crtBook")
    public String createBook(@Valid BookDto bookDto,BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "createBook";
        else
        {
            bookService.saveBook(bookDto);
            return "successAdmin";
        }
    }

    @PostMapping("updBook")
    public String updateBook(@Valid BookDto bookDto,BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "updateBook";
        else {
            bookService.updateBook(bookDto);
            return "successAdmin";
        }
    }






    @PostMapping("/retBack")
    public String goBack()
    {
        return "administratorView";
    }













}
