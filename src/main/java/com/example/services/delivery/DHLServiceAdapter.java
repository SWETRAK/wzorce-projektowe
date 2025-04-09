package com.example.services.delivery;

import com.example.services.delivery.mediator.DeliveryComponent;
import com.example.services.delivery.mediator.DeliveryMediator;
import com.example.services.delivery.mediator.Mediator;
import com.example.services.external.DHLDeliveryService;

// Tydzień 3, Wzorzec Adapter, Kamil Pietrak
// Klasa adaptera dla wysyłek DHL korzystająca z "zewnętrznego serwisu". Dostosowuje "zewnętrzną" bibliotekę do designu systemu
public class DHLServiceAdapter extends DeliveryComponent implements DeliveryService {

    // Tydzień 5, Wzorzec Mediator, Kamil Pietrak
    // Kurier DHL, który otrzymuje powiadomienia o odbiorze przesyłki
    public DHLServiceAdapter() {
        super(new DeliveryMediator(), "DHL");
    }

    public DHLServiceAdapter(Mediator mediator) {
        super(mediator, "DHL");
    }

    @Override
    public void receiveMessage(String sender, String message) {
        System.out.println("DHL received message from " + sender + ": " + message);
    }
    // Koniec, Tydzień 5, Wzorzec Mediator, Kamil Pietrak

    // Tydzień 6, Wzorzec Template, Kamil Pietrak
    // Konkretny proces wysyłki dla DHL
    @Override
    protected void preparePackage(String packageId) {
        System.out.println("Preparing package for DHL: " + packageId);
    }

    @Override
    protected void send(String packageId) {
        System.out.println("Sending via DHL: " + packageId);
    }
    // Koniec, Tydzień 6, Wzorzec Strategy, Kamil Pietrak

    private final DHLDeliveryService deliveryService = new DHLDeliveryService();

    @Override
    public void deliverOrder(String orderId) {
        deliveryService.deliverOrder(orderId);
    }

    @Override
    public void getOrderStatus(String orderId) {
        deliveryService.getOrderStatus(orderId);
    }
}

// Koniec, Tydzień 3, Wzorzec Adapter, Kamil Pietrak
