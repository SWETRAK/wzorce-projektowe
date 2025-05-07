package com.example.services.exporter;

import com.example.models.books.Book;

public class PDFExporter implements Exporter, PDFExport {

    @Override
    public void visitBook(Book book) {
        System.out.println("Exporting to PDF: " + book.getTitle());
    }

    @Override
    public void exportPDF(String data) {
        System.out.println("Exporting to PDF: " + data);
    }
}
