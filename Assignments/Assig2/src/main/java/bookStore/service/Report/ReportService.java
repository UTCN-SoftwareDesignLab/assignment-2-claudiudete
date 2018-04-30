package bookStore.service.Report;

import bookStore.entity.Book;

import java.util.List;

public interface ReportService {

    void createReport(List<Book> books);
}
