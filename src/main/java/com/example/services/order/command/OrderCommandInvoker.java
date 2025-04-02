package com.example.services.order.command;

import java.util.Stack;

// Tydzień 5, Wzorzec Command, Maciej Potręć
// Klasa do zarządzania historią komend zamówień
public class OrderCommandInvoker {
    private final Stack<OrderCommand> history = new Stack<>();

    public void executeCommand(OrderCommand command) {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            OrderCommand command = history.pop();
            command.undo();
        } else {
            System.out.println("Brak operacji do cofnięcia");
        }
    }

    public void printHistory() {
        StringBuilder historyString = new StringBuilder("Historia operacji:\n");
        for (OrderCommand command : history) {
            historyString.append(command.getClass().getSimpleName()).append("\n");
        }
        System.out.println(historyString.toString());
    }
}
// Koniec, Tydzień 5, Wzorzec Command, Maciej Potręć
