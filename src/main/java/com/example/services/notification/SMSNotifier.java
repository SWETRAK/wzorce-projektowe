package com.example.services.notification;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Implementacja notyfikacji drogą SMS
public class SMSNotifier implements Notifier {
    @Override
    public void send(String user, String message) {
        System.out.println("Wysyłanie SMS do " + user + ": " + message);
    }
}
//Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar