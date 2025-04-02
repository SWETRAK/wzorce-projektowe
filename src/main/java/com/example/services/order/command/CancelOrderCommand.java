package com.example.services.order.command;

// Tydzień 5, Wzorzec Command, Maciej Potręć
// Komenda do anulowania zamówienia
public class CancelOrderCommand implements OrderCommand {
    private final OrderProcessor processor;
    private final String orderId;

    public CancelOrderCommand(OrderProcessor processor, String orderId) {
        this.processor = processor;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        processor.cancelOrder(orderId);
    }

    @Override
    public void undo() {
        processor.undoCancellation(orderId);
    }
}
// Koniec, Tydzień 5, Wzorzec Command, Maciej Potręć
