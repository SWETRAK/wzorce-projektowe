package com.example.services.order.facade;

import com.example.models.cart.ShoppingCart;
import com.example.models.users.Client;
import com.example.models.utils.InvoicingService;

// Tydzień 4, Wzorzec Fasada, Maciej Potręć
// Klasa stworzona w celu uporządkowania procesu generowania faktury
public class InvoiceManager {
    public void generateInvoice(Client client, ShoppingCart cart, String orderId) {
        InvoicingService invoicingService = InvoicingService.getInstance();

        StringBuilder invoiceDetails = new StringBuilder();
        invoiceDetails.append("Invoice for Order: ").append(orderId).append("\n");
        invoiceDetails.append("Customer: ").append(client.getFirstName()).append(" ").append(client.getLastName()).append("\n");
        invoiceDetails.append("Email: ").append(client.getEmail()).append("\n\n");
        invoiceDetails.append("Items:\n");

        cart.display();

        invoicingService.printInvoice(invoiceDetails.toString(), cart);
    }
}
// Koniec, Tydzień 4, Wzorzec Fasada, Maciej Potręć
