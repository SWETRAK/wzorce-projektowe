package com.example.services.delivery;

import com.example.services.delivery.mediator.DeliveryComponent;
import com.example.services.delivery.mediator.DeliveryMediator;
import com.example.services.delivery.mediator.Mediator;
import com.example.services.external.InPostDeliveryService;

// Tydzień 3, Wzorzec Adapter, Kamil Pietrak
// Klasa adaptera dla wysyłek InPost korzystająca z "zewnętrznego serwisu". Dostosowuje "zewnętrzną" bibliotekę do designu systemu
public class InPostServiceAdapter extends DeliveryComponent implements DeliveryService{

    private final InPostDeliveryService inPostDeliveryService = new InPostDeliveryService();

    // Tydzień 5, Wzorzec Mediator, Kamil Pietrak
    // Kurier InPost, który otrzymuje powiadomienia o odbiorze przesyłki
    public InPostServiceAdapter() {
        super(new DeliveryMediator(), "DHL");
    }

    public InPostServiceAdapter(Mediator mediator) {
        super(mediator, "InPost");
    }

    @Override
    public void receiveMessage(String sender, String message) {
        System.out.println("InPost received message from " + sender + ": " + message);
    }
    // Koniec, Tydzień 5, Wzorzec Mediator, Kamil Pietrak

    // Tydzień 6, Wzorzec Template, Kamil Pietrak
    // Konkretny proces wysyłki dla InPost
    @Override
    protected void preparePackage(String packageId) {
        System.out.println("Preparing package for InPost: " + packageId);
    }

    @Override
    protected void send(String packageId) {
        System.out.println("Sending via InPost: " + packageId);
    }
    // Koniec, Tydzień 6, Wzorzec Template, Kamil Pietrak

    @Override
    public void deliverOrder(String orderId) {
        inPostDeliveryService.deliver(orderId);
    }

    @Override
    public void getOrderStatus(String orderId) {
        inPostDeliveryService.getStatus(orderId);
    }
}
// Koniec, Tydzień 3, Wzorzec Adapter, Kamil Pietrak