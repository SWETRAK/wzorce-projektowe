package com.example.services.validation;

import com.example.models.users.Client;
import com.example.services.order.BasicOrder;
import com.example.services.order.ExpressDeliveryDecorator;
import com.example.services.order.GiftWrappingDecorator;

// Tydzień 6, Wzorzec Visitor, Maciej Potręć
// Interfejs walidatora danych
public interface DataValidator {
    ValidationResult visitClient(Client client);
    ValidationResult visitBasicOrder(BasicOrder order);
    ValidationResult visitExpressDelivery(ExpressDeliveryDecorator order);
    ValidationResult visitGiftWrapping(GiftWrappingDecorator order);
}
// Koniec - Tydzień 6, Wzorzec Visitor, Maciej Potręć
