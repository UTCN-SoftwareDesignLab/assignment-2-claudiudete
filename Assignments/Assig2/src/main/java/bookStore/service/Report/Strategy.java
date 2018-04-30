package bookStore.service.Report;

import bookStore.entity.Book;

import java.io.IOException;
import java.util.List;

public interface Strategy {

    void createReport(List<Book> books) throws Exception;
}
