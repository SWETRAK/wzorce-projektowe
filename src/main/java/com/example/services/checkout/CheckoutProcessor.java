package com.example.services.checkout;

import com.example.services.discount.dip.DiscountStrategy;
import com.example.services.invoice.dip.InvoiceGenerator;
import com.example.services.notification.DIP.NotificationService;
import com.example.services.order.Order;
// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// CheckoutProcessor jako klasa wyższego poziomu, która korzysta tylko z abstrakcji
public class CheckoutProcessor {
    private final InvoiceGenerator invoiceGenerator;
    private final DiscountStrategy discountStrategy;
    private final NotificationService notificationService;

    public CheckoutProcessor(InvoiceGenerator invoiceGenerator, DiscountStrategy discountStrategy, NotificationService notificationService) {
        this.invoiceGenerator = invoiceGenerator;
        this.discountStrategy = discountStrategy;
        this.notificationService = notificationService;
    }

    public void processCheckout(String userId, Order order) {
        double discountedPrice = discountStrategy.applyDiscount(order.calculateCost(), userId);

        invoiceGenerator.generateInvoice(order.getOrderId(), discountedPrice);

        notificationService.sendNotification(userId, "Your order has been processed. Total amount: " + discountedPrice);
    }
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
