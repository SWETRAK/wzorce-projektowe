// Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
// PDFBookExporter implementujący tylko BookExport.
package com.example.isp.impl;

import com.example.isp.abstractons.BookExport;
import com.example.isp.models.ExportFormat;
import com.example.models.books.Book;

public class PDFBookExporter implements BookExport {
    public void exportBook(Book book, ExportFormat format) {
        if (format != ExportFormat.PDF) {
            throw new IllegalArgumentException("Only PDF format supported");
        }
        System.out.println("Exporting book to PDF: " + book.getTitle());
    }
}
//Koniec, Tydzień 8, Zasada Segregacji Interfejsów (ISP) 7



