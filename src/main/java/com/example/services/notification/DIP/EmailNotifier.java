package com.example.services.notification.DIP;

// Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
// Klasa EmailNotifier implementująca interfejs UserNotifier
public class EmailNotifier implements UserNotifier {
    @Override
    public void notify(String message) {
        System.out.println("Wysyłam email: " + message);
    }
}
//Koniec - Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar