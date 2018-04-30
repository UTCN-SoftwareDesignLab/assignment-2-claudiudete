package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.entity.Book;
import bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository)
    {
        this.bookRepository=bookRepository;
    }

    @Override
    public List<Book> findAll() {
        final Iterable<Book> items=bookRepository.findAll();
        List<Book> books=new ArrayList<>();
        items.forEach(books::add);
        return books;
    }

    @Override
    public List<Book> findByGenre(String genre) {
     return bookRepository.findAllByGenre(genre);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findAllByName(name);
    }

    @Override

    public void sell(int quantity,String name) {
      Book b=bookRepository.findAllByName(name).get(0);
      if(b.getQuantity()-quantity>=0)
      {
          b.setQuantity(b.getQuantity()-quantity);

          bookRepository.setBookQuantity(b.getQuantity()-quantity,name);}
      else {
          b.setQuantity(0);
          bookRepository.setBookQuantity(0, name);
      }

    }

    public void saveBook(BookDto book)
    {
        bookRepository.save(new Book(book.getName(),book.getIsbn(),book.getGenre(),book.getAuthor(),book.getPrice(),book.getQuantity()));
    }

    public void removeByName(String name)
    {
        bookRepository.deleteByName(name);
    }

    public void updateBook(BookDto book)
    {
        bookRepository.updateBook(book.getQuantity(),book.getName(),book.getPrice(),book.getAuthor(),book.getIsbn());
    }



    public void removeAll()
    {
        bookRepository.deleteAll();
    }

    public List<Book> findAllWithQuantity(int quantity)
    {
        return bookRepository.findAllByQuantity(quantity);
    }
}
