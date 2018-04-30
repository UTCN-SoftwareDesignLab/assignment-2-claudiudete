package bookStore.service.Report;

import bookStore.entity.Book;
import bookStore.repository.BookRepository;
import bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class ReportServiceImpl implements ReportService {


    Strategy strategy;




    public ReportServiceImpl(Strategy strategy)
    {
        this.strategy=strategy;
    }


    public void createReport(List<Book> books)
    {
        try
        {

            strategy.createReport(books);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }






}
