package com.example.services.user.register.states;

import com.example.services.user.register.RegistrationContext;
import com.example.services.user.register.RegistrationState;

// Tydzień 6, Wzorzec State, Kamil Pietrak
// Konkretny stan – zakończenie rejestracji
class ConfirmState implements RegistrationState {
    public void handleRegistrationState(RegistrationContext context) {
        System.out.println("Step 3: Registration complete");
    }
}
// Koniec, Tydzień 6, Wzorzec State, Kamil Pietrak
