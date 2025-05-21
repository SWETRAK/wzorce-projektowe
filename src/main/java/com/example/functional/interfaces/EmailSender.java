package com.example.functional.interfaces;

//Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć
//Interfejs funkcyjny do wysyłania wiadomości e-mail
@FunctionalInterface
public interface EmailSender {
    void sendEmail(String recipient, String subject, String body);
}
//Koniec, Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć
