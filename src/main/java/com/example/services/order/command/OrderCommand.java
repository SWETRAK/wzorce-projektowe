package com.example.services.order.command;

// Tydzień 5, Wzorzec Command, Maciej Potręć
// Interfejs komendy - definiuje operacje do wykonania i cofnięcia
public interface OrderCommand {
    void execute();
    void undo();
}
// Koniec, Tydzień 5, Wzorzec Command, Maciej Potręć
