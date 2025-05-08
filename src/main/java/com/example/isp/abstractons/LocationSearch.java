package com.example.isp.abstractons;

import com.example.isp.models.Location;
import com.example.models.books.Book;

import java.util.List;

public interface LocationSearch {
    List<Book> findByLocation(Location location);
}
