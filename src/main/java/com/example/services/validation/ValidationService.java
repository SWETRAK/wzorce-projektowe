package com.example.services.validation;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Visitor, Maciej Potręć
// Klasa serwisowa do walidacji danych
public class ValidationService {
    private final List<DataValidator> validators = new ArrayList<>();

    public ValidationService() {
        validators.add(new ClientDataValidator());
        validators.add(new OrderValidator());
    }

    public void addValidator(DataValidator validator) {
        validators.add(validator);
    }

    public ValidationResult validate(Visitable visitable) {
        ValidationResult finalResult = new ValidationResult();

        for (DataValidator validator : validators) {
            ValidationResult result = visitable.accept(validator);
            if (!result.isValid()) {
                for (String error : result.getErrors()) {
                    finalResult.addError(error);
                }
            }
        }

        return finalResult;
    }

    public ValidationResult validateAll(List<Visitable> visitables) {
        ValidationResult finalResult = new ValidationResult();

        for (Visitable visitable : visitables) {
            ValidationResult result = validate(visitable);
            if (!result.isValid()) {
                for (String error : result.getErrors()) {
                    finalResult.addError(error);
                }
            }
        }

        return finalResult;
    }
}
// Koniec - Tydzień 6, Wzorzec Visitor, Maciej Potręć
