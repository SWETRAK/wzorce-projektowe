package com.example.services.delivery.mediator;

import java.util.HashMap;
import java.util.Map;

// Tydzień 5, Wzorzec Mediator, Kamil Pietrak
// Implementacja Mediatora zarządzającego komunikacją między systemami dostawy
public class DeliveryMediator implements Mediator {
    private Map<String, DeliveryComponent> participants = new HashMap<>();

    public void registerComponent(DeliveryComponent component) {
        participants.put(component.getName(), component);
    }

    @Override
    public void sendMessage(String sender, String receiver, String message) {
        if (participants.containsKey(receiver)) {
            participants.get(receiver).receiveMessage(sender, message);
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Kamil Pietrak