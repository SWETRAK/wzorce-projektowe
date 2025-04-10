package com.example.services.validation;

import com.example.models.users.Client;
import com.example.services.order.BasicOrder;
import com.example.services.order.ExpressDeliveryDecorator;
import com.example.services.order.GiftWrappingDecorator;

// Tydzień 6, Wzorzec Visitor, Maciej Potręć
// Klasa walidująca dane klienta
public class ClientDataValidator implements DataValidator {
    @Override
    public ValidationResult visitClient(Client client) {
        ValidationResult result = new ValidationResult();

        if (client.getFirstName() == null) {
            result.addError("First name cannot be empty");
        }

        if (client.getLastName() == null) {
            result.addError("Last name cannot be empty");
        }

        if (client.getEmail() == null) {
            result.addError("Email cannot be empty");
        } else if (!client.getEmail().contains("@")) {
            result.addError("Email must contain @ symbol");
        }

        return result;
    }

    @Override
    public ValidationResult visitBasicOrder(BasicOrder order) {
        return new ValidationResult();
    }

    @Override
    public ValidationResult visitExpressDelivery(ExpressDeliveryDecorator order) {
        return new ValidationResult();
    }

    @Override
    public ValidationResult visitGiftWrapping(GiftWrappingDecorator order) {
        return new ValidationResult();
    }
}
// Koniec - Tydzień 6, Wzorzec Visitor, Maciej Potręć

