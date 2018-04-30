package bookStore.service.Report;

import bookStore.entity.Book;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


import java.util.ArrayList;
import java.util.List;

public class CreatePDFReport implements Strategy {
    @Override
    public void createReport(List<Book> books) throws Exception{

        PDDocument document = new PDDocument();
        PDPage page =new PDPage();
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.beginText();
        contentStream.setFont( PDType1Font.TIMES_ROMAN, 14 );
        contentStream.setLeading(14.5f);
        contentStream.newLineAtOffset(25, 700);
        contentStream.showText("The books that are out of stock are:");
        contentStream.newLine();
        int nrRows=1;

        for(Book book:books)
        {
            contentStream.showText(nrRows+". "+book.toString());
            nrRows++;
            contentStream.newLine();

            if(nrRows%40==0)
            {
                contentStream.endText();
                contentStream.close();
                document.addPage(page);
                page=new PDPage();
                contentStream = new PDPageContentStream(document, page);
                contentStream.beginText();
                contentStream.setFont( PDType1Font.TIMES_ROMAN, 14 );
                contentStream.setLeading(14.5f);
                contentStream.newLineAtOffset(25, 700);
            }
        }



        contentStream.endText();
        contentStream.close();
        document.addPage(page);
        document.save("E:\\Facultate\\Anu 3\\Sem2\\report.pdf");
        document.close();

    }

    public static void main(String[] args) throws Exception {
        List<Book> books=new ArrayList<>();
        for(int i=0;i<80;i++)
        {
            Book b =new Book("a","123","war","nimeni",i,i);
            books.add(b);

        }
        CreatePDFReport cr=new CreatePDFReport();
        cr.createReport(books);
    }
}
