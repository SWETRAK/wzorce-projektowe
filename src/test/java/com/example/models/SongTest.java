package com.example.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tydzień 12, Testy jednostkowe, Joanna Kozar
// Klasa testowa dla Song, która sprawdza różne funkcjonalności piosenek
class SongTest {

    //Test sprawdza czy konstruktor poprawnie inicjalizuje obiekt z tytułem i czasem trwania
    @Test
    void shouldCreateSongWithTitleAndDuration() {
        String expectedTitle = "Bohemian Rhapsody";
        double expectedDuration = 5.55;

        Song song = new Song(expectedTitle, expectedDuration);

        assertEquals(expectedTitle, song.getTitle());
        assertEquals(expectedDuration, song.getDuration());
    }

    // Test sprawdza czy getter getTitle() zwraca prawidłowy tytuł
    @Test
    void shouldReturnCorrectTitleFromGetter() {
        String title = "Imagine";
        double duration = 3.07;
        Song song = new Song(title, duration);

        String actualTitle = song.getTitle();

        assertEquals("Imagine", actualTitle);
    }

    // Test sprawdza czy getter getDuration() zwraca prawidłowy czas trwania
    @Test
    void shouldReturnCorrectDurationFromGetter() {
        String title = "Stairway to Heaven";
        double duration = 8.02;
        Song song = new Song(title, duration);

        double actualDuration = song.getDuration();

        assertEquals(8.02, actualDuration, 0.001);
    }

    //Test sprawdza czy metoda toString() formatuje wyjście zgodnie z oczekiwanym wzorcem
    @Test
    void shouldFormatToStringCorrectly() {
        String title = "Hotel California";
        double duration = 6.30;
        Song song = new Song(title, duration);

        String result = song.toString();

        assertEquals("Hotel California (6.3 min)", result);
    }

    //Test sprawdza tworzenie wielu różnych obiektów Song i weryfikuje że są to różne instancje
    @Test
    void shouldCreateMultipleDifferentSongs() {
        Song song1 = new Song("Yesterday", 2.05);
        Song song2 = new Song("Hey Jude", 7.11);
        Song song3 = new Song("Let It Be", 3.50);

        assertAll(
                () -> assertEquals("Yesterday", song1.getTitle()),
                () -> assertEquals(2.05, song1.getDuration(), 0.001),
                () -> assertEquals("Hey Jude", song2.getTitle()),
                () -> assertEquals(7.11, song2.getDuration(), 0.001),
                () -> assertEquals("Let It Be", song3.getTitle()),
                () -> assertEquals(3.50, song3.getDuration(), 0.001)
        );

        assertNotSame(song1, song2);
        assertNotSame(song2, song3);
        assertNotSame(song1, song3);
    }
}
//Koniec - Tydzień 12, Testy jednostkowe, Joanna Kozar