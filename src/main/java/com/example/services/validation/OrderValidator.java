package com.example.services.validation;

import com.example.models.users.Client;
import com.example.services.order.BasicOrder;
import com.example.services.order.ExpressDeliveryDecorator;
import com.example.services.order.GiftWrappingDecorator;
import com.example.services.order.state.OrderState;

// Tydzień 6, Wzorzec Visitor, Maciej Potręć
// Klasa walidująca dane zamówienia
public class OrderValidator implements DataValidator {

    private final static int BOTTOM_COST_LIMIT = 0;

    @Override
    public ValidationResult visitClient(Client client) {
        return new ValidationResult();
    }

    @Override
    public ValidationResult visitBasicOrder(BasicOrder order) {
        ValidationResult result = new ValidationResult();

        if (order.getOrderId() == null) {
            result.addError("Order ID cannot be empty");
        }

        if (order.getBaseCost() <= BOTTOM_COST_LIMIT) {
            result.addError("Order cost must be greater than zero");
        }

        OrderState state = order.getState();
        if (state == null) {
            result.addError("Order must have a valid state");
        }

        return result;
    }

    @Override
    public ValidationResult visitExpressDelivery(ExpressDeliveryDecorator order) {
        ValidationResult result = new ValidationResult();

        if (order.getOrderId() == null) {
            result.addError("Order ID cannot be empty");
        }

        if (order.calculateCost() <= BOTTOM_COST_LIMIT) {
            result.addError("Order with express delivery must have cost greater than zero");
        }

        return result;
    }

    @Override
    public ValidationResult visitGiftWrapping(GiftWrappingDecorator order) {
        ValidationResult result = new ValidationResult();

        if (order.getOrderId() == null) {
            result.addError("Order ID cannot be empty");
        }

        if (order.calculateCost() <= BOTTOM_COST_LIMIT) {
            result.addError("Order with gift wrapping must have cost greater than zero");
        }

        return result;
    }
}
// Koniec - Tydzień 6, Wzorzec Visitor, Maciej Potręć
