package com.example.services.validation;

import com.example.models.users.Client;
import com.example.services.order.BasicOrder;
import com.example.services.order.ExpressDeliveryDecorator;
import com.example.services.order.GiftWrappingDecorator;

// Tydzień 6, Wzorzec Visitor, Maciej Potręć
// Klasa adaptująca różne elementy do wzorca odwiedzającego
public class VisitableAdapter {
    public static Visitable adapt(Client client) {
        return validator -> validator.visitClient(client);
    }

    public static Visitable adapt(BasicOrder order) {
        return validator -> validator.visitBasicOrder(order);
    }

    public static Visitable adapt(ExpressDeliveryDecorator order) {
        return validator -> validator.visitExpressDelivery(order);
    }

    public static Visitable adapt(GiftWrappingDecorator order) {
        return validator -> validator.visitGiftWrapping(order);
    }
}
// Koniec - Tydzień 6, Wzorzec Visitor, Maciej Potręć
