package com.example.services.notification.DIP;

// Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
// Klasa abstrakcyjna AbstractNotifier
public abstract class AbstractNotifier {
    protected UserNotifier notifier;

    public AbstractNotifier(UserNotifier notifier) {
        this.notifier = notifier;
    }

    public void send(String msg) {
        notifier.notify(msg);
    }
}
//Koniec - Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
