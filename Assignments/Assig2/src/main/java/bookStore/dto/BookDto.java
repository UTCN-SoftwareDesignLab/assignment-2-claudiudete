package bookStore.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BookDto {

    @Size(min = 1)
    private String name;

    @Pattern(regexp = "^[1-9]+$")
    @Size(min = 5, max = 5, message = "ISBN is the wrong size")
    private String isbn;


    private String genre;
    private String author;

    @Min(0)
    private int price;

    @Min(0)
    private int quantity;

    public BookDto(@Size(min = 1) String name, @Pattern(regexp = "^[1-9]+$") @Size(min = 5, max = 5, message = "ISBN is the wrong size") String isbn, String genre, String author, int price, int quantity) {
        this.name = name;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public BookDto()
    {

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
}
