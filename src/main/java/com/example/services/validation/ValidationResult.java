package com.example.services.validation;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Visitor, Maciej Potręć
// Klasa reprezentująca wynik walidacji
@Getter
public class ValidationResult {
    private boolean valid = true;
    private final List<String> errors = new ArrayList<>();

    public void addError(String error) {
        valid = false;
        errors.add(error);
    }

    @Override
    public String toString() {
        if (valid) {
            return "Validation passed - no errors";
        } else {
            return "Validation failed:\n- " + String.join("\n- ", errors);
        }
    }
}
// Koniec - Tydzień 6, Wzorzec Visitor, Maciej Potręć
