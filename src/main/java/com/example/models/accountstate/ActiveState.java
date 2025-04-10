package com.example.models.accountstate;

//Tydzień 6, wzorzec State, Joanna Kozar
//Implementacja stanu aktywnego konta implementującego stan konta użytkownika
public class ActiveState implements AccountState {
    @Override
    public void handle() {
        System.out.println("Konto aktywne – pełna funkcjonalność.");
    }
}
//Koniec - Tydzień 6, wzorzec State, Joanna Kozar