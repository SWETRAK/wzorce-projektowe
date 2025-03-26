package com.example.models.delivery;

// Tydzień 4, Wzorzec Flyweight, Kamil Pietrak
// Klasa przechowująca informacje o przesyłkach
public class DeliveryInfo {
    private final String courierName;
    private final String trackingNumber;

    public DeliveryInfo(String courierName, String trackingNumber) {
        this.courierName = courierName;
        this.trackingNumber = trackingNumber;
    }

    public void displayDeliveryDetails() {
        System.out.println("Courier: " + courierName + " | Tracking: " + trackingNumber);
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Kamil Pietrak