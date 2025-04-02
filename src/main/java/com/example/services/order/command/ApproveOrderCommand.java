package com.example.services.order.command;

// Tydzień 5, Wzorzec Command, Maciej Potręć
// Komenda do zatwierdzania zamówienia
public class ApproveOrderCommand implements OrderCommand {
    private final OrderProcessor processor;
    private final String orderId;

    public ApproveOrderCommand(OrderProcessor processor, String orderId) {
        this.processor = processor;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        processor.approveOrder(orderId);
    }

    @Override
    public void undo() {
        processor.undoApproval(orderId);
    }
}
// Koniec, Tydzień 5, Wzorzec Command, Maciej Potręć
