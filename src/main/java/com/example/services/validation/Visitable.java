package com.example.services.validation;

// Tydzień 6, Wzorzec Visitor, Maciej Potręć
// Interfejs reprezentujący elementy, które mogą być odwiedzane przez walidatory
public interface Visitable {
    ValidationResult accept(DataValidator validator);
}
// Koniec - Tydzień 6, Wzorzec Visitor, Maciej Potręć
