package Classes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;

public class CeateReport {
    public void createThrReport(String name,String nom,String prnom,String date,String revn,String prix) throws IOException, DocumentException {
        Document document = new Document();
        FileOutputStream file = new FileOutputStream("E:\\ccc\\BDA1\\src\\Reports\\"+name+".pdf");
        PdfWriter pdfWriter = PdfWriter.getInstance(document,file);
        document.open();
        document.add(new Paragraph(String.valueOf(LocalDate.now())+"\n\n\n\n "));
        document.add(new Paragraph("                                                               Facture     "));
        document.add(new Paragraph("\n\n\nNom :  "+nom));
        document.add(new Paragraph("\nPremon :  "+prnom));
        document.add(new Paragraph("\nDate d'emmision :  "+date));
        document.add(new Paragraph("\nReservation N :  "+revn));
        document.add(new Paragraph("\nTotale :  "+prix+" DZD"));
        document.add(new Paragraph("\n\n\n\n  "));
        document.add(new Paragraph("\nSignature d'agence : "));
        document.add(new Paragraph("\n        ."));
        document.close();
        pdfWriter.close();
        File filepdf = new File("E:\\ccc\\BDA1\\src\\Reports\\"+name+".pdf");
        Desktop.getDesktop().open(filepdf);
    }

    public static void main(String[] args) throws IOException, DocumentException {
        CeateReport createReport = new CeateReport();
        createReport.createThrReport("test","ilyes","bou","11-02+5555","15","1200");
    }
}
