package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.entity.Book;
import bookStore.repository.BookRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

    @Mock
    BookRepository bookRepository;

    BookService bookService;

    @Before
    public void setup()
    {
        bookService=new BookServiceImpl(bookRepository);
    }

    @Test
    public void findAll() {

     Book book=new Book("blalba","12345","war","sdasda",11,11);
        List<Book> books= new ArrayList<>();
        books.add(book);
        books.add(book);
        books.add(book);
        Mockito.when(bookRepository.findAll()).thenReturn(books);
        assertTrue(bookService.findAll().size()==3);



    }

    @Test
    public void findByGenre() {

        BookService bookService=mock(BookServiceImpl.class);
        Book book=new Book("blalba","12345","war","sdasda",11,11);
        List<Book> books= new ArrayList<>();
        books.add(book);
        books.add(book);
        books.add(book);
        String author="sdasda";
        Mockito.when(bookService.findByAuthor(author)).thenReturn(books);


        assertTrue(bookService.findByAuthor(author).size()==3);
    }

    @Test
    public void findByTitle() {

        BookService bookService=mock(BookServiceImpl.class);
        BookDto book=new BookDto("blalba","12345","war","sdasda",11,11);
        bookService.saveBook(book);
        bookService.saveBook(book);
        bookService.saveBook(book);
        System.out.println(bookService.findAll().size());
        assertTrue(bookService.findAll().size()==0);
    }

    @Test
    public void findByAuthor() {

        BookService bookService=mock(BookServiceImpl.class);
        BookDto book=new BookDto("blalba","12345","war","sdasda",11,11);
        bookService.saveBook(book);
        bookService.saveBook(book);
        bookService.saveBook(book);
        System.out.println(bookService.findByAuthor("sdasda").size());
        assertTrue(bookService.findByAuthor("sdasda").size()==0);
    }

    @Test
    public void sell() {
    }

    @Test
    public void removeByName() {
    }
}