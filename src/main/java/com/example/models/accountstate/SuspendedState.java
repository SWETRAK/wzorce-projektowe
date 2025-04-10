package com.example.models.accountstate;

//Tydzień 6, wzorzec State, Joanna Kozar
//Implementacja stanu zawieszonego konta implementującego stan konta użytkownika
public class SuspendedState implements AccountState {
    @Override
    public void handle() {
        System.out.println("Konto zawieszone – brak dostępu do niektórych funkcji.");
    }
}
//Koniec - Tydzień 6, wzorzec State, Joanna Kozar
