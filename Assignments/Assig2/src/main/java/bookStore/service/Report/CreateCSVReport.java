package bookStore.service.Report;

import bookStore.entity.Book;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateCSVReport implements Strategy {


    @Override
    public void createReport(List<Book> books) throws Exception {

        PrintWriter pw = new PrintWriter(new File("E:\\Facultate\\Anu 3\\Sem2\\CSVReport.csv"));
        StringBuilder sb=new StringBuilder();
        sb.append("Nr");
        sb.append(",");
        sb.append("name");
        sb.append(",");
        sb.append("author");
        sb.append(",");
        sb.append("genre");
        sb.append(",");
        sb.append("price");
        sb.append('\n');

        pw.write(sb.toString());
        sb.delete(0,sb.length());
        int counter=0;
        for(Book b:books)
        {
            counter++;
            sb.append(counter);
            sb.append(",");
            sb.append(b.getName());
            sb.append(",");
            sb.append(b.getAuthor());
            sb.append(",");
            sb.append(b.getGenre());
            sb.append(",");
            sb.append(b.getPrice());
            sb.append('\n');
            pw.write(sb.toString());
            sb.delete(0,sb.length());
        }

        pw.close();




    }

    public static void main(String[] args) throws Exception {
        List<Book> books=new ArrayList<>();
        for(int i=0;i<80;i++)
        {
            Book b =new Book("a","123","war","nimeni",i,i);
            books.add(b);

        }
        CreateCSVReport cr=new CreateCSVReport();
        cr.createReport(books);
    }


}
