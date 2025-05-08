package com.example.services.delivery;

import com.example.services.external.CalendarService;

// Tydzień 7, Zasada SRP, Kamil Pietrak
// Klasa odpowiedzialna tylko za planowanie dostaw
public class DeliveryScheduler {

    private final CalendarService calendarService;

    public DeliveryScheduler(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    public void scheduleDelivery(String address, String date) {
        calendarService.addEvent("Delivery to: " + address, date);
        System.out.println("Scheduled delivery to " + address + " on " + date);
    }
}
// Koniec, Tydzień 7, Zasada SRP, Kamil Pietrak