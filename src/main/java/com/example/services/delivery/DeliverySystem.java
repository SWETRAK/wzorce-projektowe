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

    @Override
    protected void preparePackage(String packageId) {
        System.out.println("OrderSystem preparing package " + packageId);
    }

    @Override
    protected void send(String packageId) {
        System.out.println("OrderSystem sending package " + packageId);
    }

    @Override
    public void deliverOrder(String orderId) {
        System.out.println("OrderSystem delivering order " + orderId);
        mediator.sendMessage(getName(), "DHL", "Deliver order");
        mediator.sendMessage(getName(), "InPost", "Deliver order");
    }

    @Override
    public void getOrderStatus(String orderId) {
        System.out.println("OrderSystem getting order status for " + orderId);
        mediator.sendMessage(getName(), "DHL", "Check order status");
        mediator.sendMessage(getName(), "InPost", "Check order status");
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Kamil Pietrak