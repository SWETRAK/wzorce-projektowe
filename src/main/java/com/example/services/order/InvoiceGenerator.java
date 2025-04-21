package com.example.services.order;

import com.example.models.cart.ShoppingCart;
import com.example.models.users.Client;
import com.example.services.order.facade.InvoiceManager;

// Tydzień 7, Zasada SRP, Kamil Pietrak
// Klasa odpowiedzialna tylko za generowanie faktur PDF
public class InvoiceGenerator {
    private final InvoiceManager renderer;

    public InvoiceGenerator(InvoiceManager renderer) {
        this.renderer = renderer;
    }

    public void generateInvoice(Client client, ShoppingCart cart, String orderId) {
        renderer.generateInvoice(client, cart, orderId);
    }
}
// Koniec, Tydzień 7, Zasada SRP, Kamil Pietrak