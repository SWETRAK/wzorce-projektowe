package com.example.services.discount;

// Tydzień 7, Single Responsibility Principle, Joanna Kozar
// Klasa odpowiada tylko za wysyłkę powiadomień o promocjach
public class PromotionNotifier {
    public void notifyUser(String userEmail, String message) {
        System.out.println("Wysyłam powiadomienie do " + userEmail + ": " + message);
    }
}
// Koniec - Tydzień 7, Single Responsibility Principle, Joanna Kozar