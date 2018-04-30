package bookStore.controller;

import bookStore.dto.BookDto;
import bookStore.entity.Book;
import bookStore.repository.BookRepository;
import bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@Controller
public class BookController {



    private BookService bookService;

    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService=bookService;
    }


    @GetMapping("/userView")
    public String showView()
    {
        return "userView";
    }


    @PostMapping("/booksByGenre")
    public String showBooksByGenre(Model model)
    {
        model.addAttribute("book",new BookDto());
        return "booksByGenre";
    }
    @PostMapping("/booksByAuthor")
    public String showBooksByAuthor(Model model)
    {
        model.addAttribute("book",new BookDto());
        return "booksByAuthor";
    }

    @PostMapping("/booksByTitle")
    public String showBooksByTitle(Model model)
    {
        model.addAttribute("book",new BookDto());
        return "booksByTitle";
    }

    @PostMapping("/sellBooks")
    public String showSellBooks(Model model)
    {
        List<Book> books=bookService.findAll();
        model.addAttribute("book",new BookDto());
        model.addAttribute("bookLst",books);

        return "sellBooks";
    }


    @PostMapping("/sellBooksByIsbn")
    public ModelAndView sellBooks(@ModelAttribute("quantity") String quantity,@ModelAttribute("name") String name)
    {
        bookService.sell(Integer.parseInt(quantity),name);

        List<Book> books=bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("showBooks");

        modelAndView.addObject("bookList", books);

        return modelAndView;
    }




    @PostMapping("/findBooksByGenre")
    public ModelAndView getBooksByGenre(@ModelAttribute("genre") String genre) {

        List<Book> books;

        books = bookService.findByGenre(genre);

        ModelAndView modelAndView = new ModelAndView("showBooks");

        modelAndView.addObject("bookList", books);

        return modelAndView;
    }

    @PostMapping("/findBooksByAuthor")
    public ModelAndView getBooksByAuthor(@ModelAttribute("author") String author) {

        List<Book> books;

        books = bookService.findByAuthor(author);

        ModelAndView modelAndView = new ModelAndView("showBooks");

        modelAndView.addObject("bookList", books);

        return modelAndView;
    }

    @PostMapping("/findBooksByTitle")
    public ModelAndView getBooksByTitle(@ModelAttribute("name") String name) {

        List<Book> books;

        books = bookService.findByName(name);

        ModelAndView modelAndView = new ModelAndView("showBooks");

        modelAndView.addObject("bookList", books);

        return modelAndView;
    }

    @PostMapping("/displayBook")
    public ModelAndView getAllBooks() {

        List<Book> books;

        books = bookService.findAll();

        ModelAndView modelAndView = new ModelAndView("showBooks");

        modelAndView.addObject("bookList", books);

        return modelAndView;
    }

    @PostMapping("/returnBack")
    public String goBack()
    {
        return "userView";
    }





}
