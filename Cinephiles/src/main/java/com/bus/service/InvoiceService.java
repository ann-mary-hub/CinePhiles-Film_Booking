package com.bus.service;

import com.bus.beans.OrderHistory;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;


@Service
public class InvoiceService {

    public byte[] generateInvoicePdf(OrderHistory history) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter.getInstance((com.itextpdf.text.Document) document, out);

         document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

        document.add(new Paragraph("Movie Ticket Invoice", titleFont));
        document.add(new Paragraph(" ")); // spacing

        document.add(new Paragraph("Movie: " + history.getMovieName(), normalFont));
        document.add(new Paragraph("Seat: " + history.getSeat(), normalFont));
        document.add(new Paragraph("Price per seat: " + history.getPrice(), normalFont));
        document.add(new Paragraph("Total: " + history.getTotal(), normalFont));
        document.add(new Paragraph("Booking Date: " + history.getBookOnDate(), normalFont));
        document.add(new Paragraph("Show Date: " + history.getShowOnDate(), normalFont));
        document.add(new Paragraph("Show Time: " + history.getShowTime(), normalFont));

        document.close();

        return out.toByteArray();
    }
}
