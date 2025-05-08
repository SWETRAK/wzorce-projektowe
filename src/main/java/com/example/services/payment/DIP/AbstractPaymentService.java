package com.example.services.payment.DIP;

// Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
// Klasa abstrakcyjna AbstractPaymentService
public abstract class AbstractPaymentService {
    protected PaymentProcessor processor;

    public AbstractPaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void executePayment(double amount) {
        processor.process(amount);
    }
}
//Koniec - Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar