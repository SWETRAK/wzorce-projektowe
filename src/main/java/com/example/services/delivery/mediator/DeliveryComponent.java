package com.example.services.delivery.mediator;

import lombok.Getter;

// Tydzień 5, Wzorzec Mediator, Kamil Pietrak
// Abstrakcyjna klasa reprezentująca komponent systemu dostawy
public abstract class DeliveryComponent {
    protected Mediator mediator;

    @Getter
    private String name;

    public DeliveryComponent(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void receiveMessage(String sender, String message);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Kamil Pietrak