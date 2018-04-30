package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    List<Book> findByGenre(String genre);
    List<Book> findByAuthor(String author);
    List<Book> findByName(String title);
    void removeAll();
    void sell(int quantity,String name);
    void removeByName(String name);
    void saveBook(BookDto book);
    void updateBook(BookDto book);
    List<Book> findAllWithQuantity(int quantity);

}
