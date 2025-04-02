package com.example.services.notification;

//Tydzień 5, Wzorzec Mediator, Joanna Kozar
//Implementacja Interfejsu mediatora do zarządzania powiadomieniami
public interface NotificationMediator {
    void register(NotificationSender sender);
    void sendNotification(String type, String recipient, String subject, String content);
}
//Koniec - Tydzień 5, Wzorzec Mediator, Joanna Kozar