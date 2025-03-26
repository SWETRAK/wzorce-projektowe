package com.example.services.order.facade;

import com.example.models.users.Client;
import com.example.services.payment.PaymentProcessor;

// Tydzień 4, Wzorzec Fasada, Maciej Potręć
// Klasa zarządzająca płatnościami
public class PaymentManager {
    public boolean processPayment(Client client, double amount, PaymentProcessor paymentProcessor) {
        System.out.println("Processing payment for client: " + client.getFirstName() + " " + client.getLastName());
        paymentProcessor.processPayment(amount);

        return true;
    }
}
// Koniec, Tydzień 4, Wzorzec Fasada, Maciej Potręć