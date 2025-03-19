package com.example.services.notification;

// Tydzień 3, Wzorzec Bridge, Maciej Potręć
// Rozszerzona abstrakcja - powiadomienie o zamówieniu
public class OrderNotification extends Notification {
    private final String orderId;

    public OrderNotification(NotificationSender sender, String orderId) {
        super(sender);
        this.orderId = orderId;
    }

    @Override
    public void send(String recipient) {
        String subject = "Order Update";
        String content = "Your order #" + orderId + " has been processed";
        sender.sendNotification(recipient, subject, content);
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Maciej Potręć
