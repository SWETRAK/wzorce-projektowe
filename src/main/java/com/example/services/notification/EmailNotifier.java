package com.example.services.notification;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Implementacja notyfikacji drogą Email
public class EmailNotifier implements Notifier {
    @Override
    public void send(String user, String message) {
        System.out.println("Wysyłanie EMAIL do " + user + ": " + message);
    }
}
//Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar