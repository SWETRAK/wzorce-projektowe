package com.example.services.user.register.states;

import com.example.services.user.register.RegistrationContext;
import com.example.services.user.register.RegistrationState;

// Tydzień 6, Wzorzec State, Kamil Pietrak
// Konkretny stan – rozpoczęcie rejestracji
public class StartState implements RegistrationState {
    public void handleRegistrationState(RegistrationContext context) {
        System.out.println("Step 1: Email entered");
        context.setState(new DetailsState());
    }
}
// Koniec, Tydzień 6, Wzorzec State, Kamil Pietrak
