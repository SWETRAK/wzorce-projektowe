package com.example.services.purchase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tydzień 12, Testy jednostkowe, Joanna Kozar
// Klasa testowa dla PurchaseHistory, która sprawdza różne funkcjonalności historii zakupów
class PurchaseHistoryTest {

    private PurchaseHistory purchaseHistory;

    @BeforeEach
    void setUp() {
        purchaseHistory = new PurchaseHistory();
    }

    //Test sprawdza dodanie pojedynczego zakupu i pobranie go przez iterator
    @Test
    void shouldAddSinglePurchaseAndRetrieveViaIterator() {
        String bookTitle = "Effective Java";

        purchaseHistory.addPurchase(bookTitle);
        PurchaseIterator iterator = purchaseHistory.getIterator();

        assertTrue(iterator.hasNext());
        assertEquals("Effective Java", iterator.next());
        assertFalse(iterator.hasNext());
    }

    // Test sprawdza dodanie wielu zakupów i iterowanie przez nie w odpowiedniej kolejności
    @Test
    void shouldAddMultiplePurchasesAndIterateInOrder() {
        String[] books = {
                "Clean Code",
                "Design Patterns",
                "Refactoring",
                "The Pragmatic Programmer"
        };

        for (String book : books) {
            purchaseHistory.addPurchase(book);
        }
        PurchaseIterator iterator = purchaseHistory.getIterator();

        for (String expectedBook : books) {
            assertTrue(iterator.hasNext());
            assertEquals(expectedBook, iterator.next());
        }
        assertFalse(iterator.hasNext());
    }

    //Test sprawdza czy każdy wywołanie getIterator() tworzy niezależny iterator, który nie wpływa na inne iteratory
    @Test
    void shouldCreateIndependentIterators() {
        purchaseHistory.addPurchase("Book One");
        purchaseHistory.addPurchase("Book Two");
        purchaseHistory.addPurchase("Book Three");

        PurchaseIterator iterator1 = purchaseHistory.getIterator();
        PurchaseIterator iterator2 = purchaseHistory.getIterator();

        assertEquals("Book One", iterator1.next());
        assertEquals("Book One", iterator2.next());

        assertEquals("Book Two", iterator1.next());
        assertEquals("Book Two", iterator2.next());

        assertTrue(iterator1.hasNext());
        assertTrue(iterator2.hasNext());

        assertEquals("Book Three", iterator1.next());
        assertFalse(iterator1.hasNext());

        assertTrue(iterator2.hasNext());
        assertEquals("Book Three", iterator2.next());
        assertFalse(iterator2.hasNext());
    }

    //Test sprawdza obsługę duplikatów w historii zakupów (czy są zachowywane)
    @Test
    void shouldHandleDuplicatePurchases() {
        String duplicateBook = "Java: The Complete Reference";

        purchaseHistory.addPurchase(duplicateBook);
        purchaseHistory.addPurchase("Spring in Action");
        purchaseHistory.addPurchase(duplicateBook); // Duplikat
        purchaseHistory.addPurchase("Hibernate Tips");

        PurchaseIterator iterator = purchaseHistory.getIterator();

        assertTrue(iterator.hasNext());
        assertEquals("Java: The Complete Reference", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Spring in Action", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Java: The Complete Reference", iterator.next()); // Duplikat zachowany

        assertTrue(iterator.hasNext());
        assertEquals("Hibernate Tips", iterator.next());

        assertFalse(iterator.hasNext());
    }

    //Test sprawdza obsługę przypadków brzegowych jak null, pusty string i string zawierający tylko białe znaki
    @Test
    void shouldHandleNullAndEmptyStringPurchases() {
        purchaseHistory.addPurchase(null);
        purchaseHistory.addPurchase("");
        purchaseHistory.addPurchase("Valid Book");
        purchaseHistory.addPurchase("   "); // Whitespace only

        PurchaseIterator iterator = purchaseHistory.getIterator();

        assertTrue(iterator.hasNext());
        assertNull(iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Valid Book", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("   ", iterator.next());

        assertFalse(iterator.hasNext());
    }
}
//Koniec - Tydzień 12, Testy jednostkowe, Joanna Kozar