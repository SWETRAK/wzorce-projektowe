package com.example.services.user.register.states;

import com.example.services.user.register.RegistrationContext;
import com.example.services.user.register.RegistrationState;

// Tydzień 6, Wzorzec State, Kamil Pietrak
// Konkretny stan – wprowadzenie danych osobowych
class DetailsState implements RegistrationState {
    public void handleRegistrationState(RegistrationContext context) {
        System.out.println("Step 2: Personal details entered");
        context.setState(new ConfirmState());
    }
}
// Koniec, Tydzień 6, Wzorzec State, Kamil Pietrak
