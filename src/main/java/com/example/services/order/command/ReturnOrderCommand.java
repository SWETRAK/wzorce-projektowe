package com.example.services.order.command;

// Tydzień 5, Wzorzec Command, Maciej Potręć
// Komenda do zwracania zamówienia
public class ReturnOrderCommand implements OrderCommand {
    private final OrderProcessor processor;
    private final String orderId;
    private final String reason;

    public ReturnOrderCommand(OrderProcessor processor, String orderId, String reason) {
        this.processor = processor;
        this.orderId = orderId;
        this.reason = reason;
    }

    @Override
    public void execute() {
        processor.processReturn(orderId, reason);
    }

    @Override
    public void undo() {
        processor.undoReturn(orderId);
    }
}
// Koniec, Tydzień 5, Wzorzec Command, Maciej Potręć
