package com.example.services.user.register;

import com.example.services.user.register.states.StartState;

// Tydzień 6, Wzorzec State, Kamil Pietrak
// Klasa kontekstu zarządzająca bieżącym stanem rejestracji
public class RegistrationContext {
    private RegistrationState state;

    public RegistrationContext() {
        this.state = new StartState();
    }

    public void setState(RegistrationState state) {
        this.state = state;
    }

    public void nextStep() {
        state.handleRegistrationState(this);
    }
}
// Koniec, Tydzień 6, Wzorzec State, Kamil Pietrak
