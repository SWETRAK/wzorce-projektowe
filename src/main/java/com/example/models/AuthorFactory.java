package com.example.models;
import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Joanna Kozar
// Fabryka obiektów Author zapewniająca współdzielenie instancji
public class AuthorFactory {
    private static final Map<String, Author> authors = new HashMap<>();

    public static Author getAuthor(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        if (!authors.containsKey(key)) {
            authors.put(key, new Author(firstName, lastName));
        }
        return authors.get(key);
    }
}
