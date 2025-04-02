package com.example.services.delivery.mediator;

// Tydzień 5, Wzorzec Mediator, Kamil Pietrak
// Interfejs Mediatora, który umożliwia komunikację między komponentami
public interface Mediator {
    void sendMessage(String sender, String receiver, String message);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Kamil Pietrak