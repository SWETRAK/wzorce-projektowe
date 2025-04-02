package com.example.services.delivery;

import com.example.services.delivery.mediator.DeliveryComponent;
import com.example.services.delivery.mediator.Mediator;

// Tydzień 5, Wzorzec Mediator, Kamil Pietrak
// System zamówień, który inicjuje proces dostawy i komunikuje się z magazynem oraz kurierem
public class DeliverySystem extends DeliveryComponent {

    public DeliverySystem(Mediator mediator) {
        super(mediator, "OrderSystem");
    }

    public void placeOrder() {
        System.out.println("Order placed, notifying warehouse and courier.");
        mediator.sendMessage(getName(), "DHL", "Prepare order");
        mediator.sendMessage(getName(), "InPost", "Pickup order");
    }

    @Override
    public void receiveMessage(String sender, String message) {
        System.out.println("OrderSystem received message from " + sender + ": " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Kamil Pietrak