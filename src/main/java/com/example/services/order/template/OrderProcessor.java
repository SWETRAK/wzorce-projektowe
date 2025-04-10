package com.example.services.order.template;

// Tydzień 6, Wzorzec Template Method, Maciej Potręć
// Klasa abstrakcyjna reprezentująca szkielet procesu przetwarzania zamówienia.
public abstract class OrderProcessor {
    public final void processOrder(String orderId, double amount) {
        verifyAvailability(orderId);
        processPayment(orderId, amount);
        deliver(orderId);
        sendConfirmation(orderId);
        if (offerAdditionalServices()) {
            handleAdditionalServices(orderId);
        }
    }

    protected void verifyAvailability(String orderId) {
        System.out.println("Verifying availability for order: " + orderId);
    }

    protected void processPayment(String orderId, double amount) {
        System.out.println("Processing payment of $" + amount + " for order: " + orderId);
    }

    protected abstract void deliver(String orderId);

    protected void sendConfirmation(String orderId) {
        System.out.println("Sending order confirmation for order: " + orderId);
    }

    protected boolean offerAdditionalServices() {
        return true;
    }

    protected void handleAdditionalServices(String orderId) {}
}
// Koniec, Tydzień 6, Wzorzec Template Method, Maciej Potręć
