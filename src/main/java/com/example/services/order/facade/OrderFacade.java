package com.example.services.order.facade;

import com.example.models.cart.ShoppingCart;
import com.example.models.users.Client;
import com.example.services.delivery.DeliveryService;
import com.example.services.payment.PaymentProcessor;

// Tydzień 4, Wzorzec Fasada, Maciej Potręć
// Fasada zamówienia - upraszcza proces zamawiania produktów
public class OrderFacade {
    private final PaymentManager paymentManager;
    private final ShippingManager shippingManager;
    private final InvoiceManager invoiceManager;

    public OrderFacade() {
        this.paymentManager = new PaymentManager();
        this.shippingManager = new ShippingManager();
        this.invoiceManager = new InvoiceManager();
    }

    public void processOrder(Client client, ShoppingCart cart, PaymentProcessor paymentProcessor, DeliveryService deliveryService) {
        String orderId = "ORD-" + System.currentTimeMillis();

        boolean paymentSuccessful = paymentManager.processPayment(client, cart.getPrice(), paymentProcessor);

        if (paymentSuccessful) {
            shippingManager.arrangeShipping(client, deliveryService, orderId);

            invoiceManager.generateInvoice(client, cart, orderId);

            System.out.println("Order " + orderId + " processed successfully!");
        } else {
            System.out.println("Order " + orderId + " processing failed.");
        }
    }
}
// Koniec, Tydzień 4, Wzorzec Fasada, Maciej Potręć