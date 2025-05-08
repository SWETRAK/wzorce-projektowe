package com.example.isp.models;

// Tydzień 8, Model danych, Kamil Pietrak
// Klasa DeliveryPlan reprezentująca plan dostawy.
public class DeliveryPlan {
    private final String planId;
    private final Address destination;
    private final String deliveryMethod;

    public DeliveryPlan(String planId, Address dest, String method) {
        this.planId = planId;
        this.destination = dest;
        this.deliveryMethod = method;
    }

    // Gettery
    public String getPlanId() { return planId; }
    public Address getDestination() { return destination; }
    public String getDeliveryMethod() { return deliveryMethod; }
}
//Koniec, Tydzień 8, Model danych (DeliveryPlan)