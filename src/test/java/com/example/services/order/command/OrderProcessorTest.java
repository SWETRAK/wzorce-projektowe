package com.example.services.order.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

// Tydzień 12, Testy jednostkowe, Maciej Potręć
// Klasa testowa dla OrderProcessor, która sprawdza różne operacje na zamówieniach
class OrderProcessorTest {
    private OrderProcessor processor;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        processor = new OrderProcessor();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testApproveOrder() {
        String orderId = "123";

        processor.approveOrder(orderId);

        String output = outputStream.toString();
        assertTrue(output.contains("Zatwierdzono zamówienie: 123"));
    }

    @Test
    void testCancelOrder() {
        String orderId = "456";

        processor.cancelOrder(orderId);

        String output = outputStream.toString();
        assertTrue(output.contains("Anulowano zamówienie: 456"));
    }

    @Test
    void testProcessReturn() {
        String orderId = "789";
        String reason = "Damaged product";

        processor.processReturn(orderId, reason);

        String output = outputStream.toString();
        assertTrue(output.contains("Zwrócono zamówienie: 789"));
        assertTrue(output.contains("Powód zwrotu: Damaged product"));
    }

    @Test
    void testUndoOperations() {
        String orderId = "123";

        processor.undoApproval(orderId);
        processor.undoCancellation(orderId);
        processor.undoReturn(orderId);

        String output = outputStream.toString();
        assertTrue(output.contains("Cofnięto zatwierdzenie zamówienia: 123"));
        assertTrue(output.contains("Cofnięto anulowanie zamówienia: 123"));
        assertTrue(output.contains("Cofnięto zwrot zamówienia: 123"));
    }

    @Test
    void testOrderOperationSequence() {
        String orderId = "2137";

        processor.approveOrder(orderId);
        processor.undoApproval(orderId);
        processor.cancelOrder(orderId);
        processor.undoCancellation(orderId);
        processor.processReturn(orderId, "Changed mind");
        processor.undoReturn(orderId);

        String output = outputStream.toString();
        assertTrue(output.contains("Zatwierdzono zamówienie: 2137"));
        assertTrue(output.contains("Cofnięto zatwierdzenie zamówienia: 2137"));
        assertTrue(output.contains("Anulowano zamówienie: 2137"));
        assertTrue(output.contains("Cofnięto anulowanie zamówienia: 2137"));
        assertTrue(output.contains("Zwrócono zamówienie: 2137"));
        assertTrue(output.contains("Powód zwrotu: Changed mind"));
        assertTrue(output.contains("Cofnięto zwrot zamówienia: 2137"));

        int approveIndex = output.indexOf("Zatwierdzono");
        int undoApproveIndex = output.indexOf("Cofnięto zatwierdzenie");
        int cancelIndex = output.indexOf("Anulowano");
        int undoCancelIndex = output.indexOf("Cofnięto anulowanie");

        assertTrue(approveIndex < undoApproveIndex);
        assertTrue(undoApproveIndex < cancelIndex);
        assertTrue(cancelIndex < undoCancelIndex);
    }
}
// Koniec, Tydzień 12, Testy jednostkowe, Maciej Potręć