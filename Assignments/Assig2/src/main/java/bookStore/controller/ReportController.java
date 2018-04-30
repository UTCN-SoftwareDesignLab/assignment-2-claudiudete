package bookStore.controller;


import bookStore.dto.BookDto;
import bookStore.entity.Book;
import bookStore.service.BookService;
import bookStore.service.Report.CreateCSVReport;
import bookStore.service.Report.CreatePDFReport;
import bookStore.service.Report.ReportService;
import bookStore.service.Report.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private BookService bookService;

      @PostMapping("/generateCSV")
    public String generateCVS()
     {
         List<Book> books=bookService.findAllWithQuantity(0);
         ReportService reportService=new ReportServiceImpl(new CreateCSVReport());
         reportService.createReport(books);
         return "Success";
     }

    @PostMapping("/generatePDF")
    public String generatePDF()
    {
        List<Book> books=bookService.findAllWithQuantity(0);
        ReportService reportService=new ReportServiceImpl(new CreatePDFReport());
        reportService.createReport(books);
        return "Success";
    }


    @PostMapping("/ret")
    public String goBack()
    {
        return "administratorView";
    }


}
