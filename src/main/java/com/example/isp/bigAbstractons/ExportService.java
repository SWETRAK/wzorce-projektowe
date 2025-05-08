package com.example.isp.bigAbstractons;

import com.example.isp.models.ExportFormat;
import com.example.models.books.Book;
import com.example.services.exporter.Exportable;
import com.example.services.invoice.renderer.Invoice;
import com.example.services.order.Order;

public interface ExportService {
    void exportBook(Book book, ExportFormat format);
    void exportOrder(Order order, ExportFormat format);
    void exportInvoice(Invoice invoice, ExportFormat format);
    byte[] generatePDF(Exportable entity);
    String generateCSV(Exportable entity);
}
//Koniec, Tydzień 8, Zasada Segregacji Interfejsów (ISP) 1