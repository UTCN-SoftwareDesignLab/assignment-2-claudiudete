package bookStore.repository;

import bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
   List<Book> findAllByGenre(String genre);
   List<Book> findAllByName(String name);
   List<Book> findAllByAuthor(String author);
   List<Book> findAllByQuantity(int quantity);

   @Modifying
   @Transactional
   @Query("update Book b set b.quantity = ?1 where b.name = ?2")
   void setBookQuantity(int quantity,String name);

   @Modifying
   @Transactional
   @Query("update Book b set b.quantity = ?1, b.name= ?2, b.price= ?3, b.author= ?4 where b.isbn = ?5")
   void updateBook(int quantity,String name,int price,String author,String isbn);

   @Transactional
   Long deleteByName(String name);




}

