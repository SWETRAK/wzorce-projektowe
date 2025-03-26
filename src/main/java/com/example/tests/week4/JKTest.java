package com.example.tests.week4;
import com.example.models.Author;
import com.example.models.AuthorFactory;
import com.example.services.publisher.*;
import com.example.services.recommendation.*;

// Tydzień 4, Testowanie wzorców projektowych, Joanna Kozar
// Klasa testowa sprawdzająca działanie wzorców: Facade, Proxy, Flyweight

public class JKTest {
    public static void main(String[] args) {
        // Facade - system rekomendacji
        RecommendationFacade recommendationFacade = new RecommendationFacade();
        recommendationFacade.recommendBasedOnHistory();

        // Proxy - dostęp do API wydawnictwa, po drugim wywołaniu cache
        PublisherInterfaceAPI publisherAPI = new PublisherAPIProxy();
        System.out.println(publisherAPI.getBookInfo("0316333522"));
        System.out.println(publisherAPI.getBookInfo("0316333522"));

        // Flyweight - wielokrotne użycie tych samych obiektów autorów
        Author author1 = AuthorFactory.getAuthor("Andrzej", "Sapkowski");
        Author author2 = AuthorFactory.getAuthor("Andrzej", "Sapkowski");
        System.out.println("Czy author1 i author2 to ten sam obiekt? " + (author1 == author2));
    }
}
