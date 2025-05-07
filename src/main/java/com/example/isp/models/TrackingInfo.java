package com.example.isp.models;

// Tydzień 8, Model danych, Kamil Pietrak
// Klasa TrackingInfo reprezentująca status przesyłki.
public class TrackingInfo {
    private final String trackingNumber;
    private final String status;
    private final String estimatedDelivery;

    public TrackingInfo(String number, String status, String deliveryDate) {
        this.trackingNumber = number;
        this.status = status;
        this.estimatedDelivery = deliveryDate;
    }

    // Gettery
    public String getTrackingNumber() { return trackingNumber; }
    public String getStatus() { return status; }
    public String getEstimatedDelivery() { return estimatedDelivery; }
}
//Koniec, Tydzień 8, Model danych (TrackingInfo)