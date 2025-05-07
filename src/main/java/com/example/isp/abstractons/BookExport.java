package com.example.isp.abstractons;

import com.example.isp.models.ExportFormat;
import com.example.models.books.Book;

public interface BookExport {
    void exportBook(Book book, ExportFormat format);
}

