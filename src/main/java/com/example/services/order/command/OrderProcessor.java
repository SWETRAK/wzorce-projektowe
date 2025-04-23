package com.example.services.order.command;

// Tydzień 7, Zasada SRP, Maciej Potręć
// Klasa która odpowiada za wykonanie różnych operacji na zamówieniach

// Tydzień 5, Wzorzec Command, Maciej Potręć
// Receiver - wykonuje operacje na zamówieniach
public class OrderProcessor {
    public void approveOrder(String orderId) {
        System.out.println("Zatwierdzono zamówienie: " + orderId);
    }

    public void cancelOrder(String orderId) {
        System.out.println("Anulowano zamówienie: " + orderId);
    }

    public void processReturn(String orderId, String reason) {
        StringBuilder sb = new StringBuilder();
        sb.append("Zwrócono zamówienie: ").append(orderId).append("\n");
        sb.append("Powód zwrotu: ").append(reason).append("\n");
        System.out.println(sb);
    }

    // Metody odwracające operacje
    public void undoApproval(String orderId) {
        System.out.println("Cofnięto zatwierdzenie zamówienia: " + orderId);
    }

    public void undoCancellation(String orderId) {
        System.out.println("Cofnięto anulowanie zamówienia: " + orderId);
    }

    public void undoReturn(String orderId) {
        System.out.println("Cofnięto zwrot zamówienia: " + orderId);
    }
}
// Koniec, Tydzień 5, Wzorzec Command, Maciej Potręć
// Koniec, Tydzień 7, Zasada SRP, Maciej Potręć