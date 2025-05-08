
package com.example.models.books.export;

import com.example.models.books.Book;

// Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
// XMLBookExporter implementujący tylko interfejs BookExport.
public class XMLBookExporter implements BookExport {
    public void exportBook(Book book) {
        System.out.println("Exporting book to XML: " + book.getTitle());
    }
}
//Koniec, Tydzień 8, Zasada Segregacji Interfejsów (ISP) 2