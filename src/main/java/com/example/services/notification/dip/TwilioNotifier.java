package com.example.services.notification.dip;

// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// TwilioNotifier jako konkretna implementacja wysyłania powiadomień przez Twilio
public class TwilioNotifier extends BaseNotifier {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending notification via Twilio to " + recipient + ": " + message);
    }
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
