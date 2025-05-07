// Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
// BookExport jako wąski interfejs do eksportu książek (ISP).
package com.example.models.books.export;

import com.example.models.books.Book;

public interface BookExport {
    void exportBook(Book book);
}
//Koniec, Tydzień 8, Zasada Segregacji Interfejsów (ISP) 1