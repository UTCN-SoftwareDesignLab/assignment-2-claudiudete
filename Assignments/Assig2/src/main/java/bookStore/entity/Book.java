package bookStore.entity;


import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    public Book(String name, String isbn, String genre, String author, int price, int quantity) {
        this.name = name;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public Book()
    {

    }

    @Column(unique=true)
    private String name;
    private String isbn;

    private String genre;
    private String author;
    private int price;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString()
    {
        return this.name+" "+this.author+" "+this.genre+" "+this.price;
    }
}
