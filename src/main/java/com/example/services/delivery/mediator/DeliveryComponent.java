package com.example.services.delivery.mediator;

import com.example.services.delivery.DeliveryService;
import lombok.Getter;

// Tydzień 5, Wzorzec Mediator, Kamil Pietrak
// Abstrakcyjna klasa reprezentująca komponent systemu dostawy
public abstract class DeliveryComponent implements DeliveryService {
    protected Mediator mediator;

    @Getter
    private String name;

    public DeliveryComponent(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void receiveMessage(String sender, String message);

    // Tydzień 6, Wzorzec Template, Kamil Pietrak
    // Klasa szablonowa definiująca ogólny proces wysyłki
    public final void shipPackage(String packageId) {
        preparePackage(packageId);
        labelPackage(packageId);
        send(packageId);
    }

    protected abstract void preparePackage(String packageId);
    protected abstract void send(String packageId);

    private void labelPackage(String packageId) {
        System.out.println("Labeling package: " + packageId);
    }
    // Koniec, Tydzień 6, Wzorzec Strategy, Kamil Pietrak

    public abstract void deliverOrder(String orderId);

    public abstract void getOrderStatus(String orderId);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Kamil Pietrak