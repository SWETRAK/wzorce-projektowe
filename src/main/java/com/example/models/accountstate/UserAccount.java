package com.example.models.accountstate;

//Tydzień 6, wzorzec State, Joanna Kozar
//Implementacja klasy zarządzającej stanem konta użytkownika
public class UserAccount {
    private AccountState state;

    public UserAccount() {
        this.state = new ActiveState();
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void handle() {
        state.handle();
    }
}
//Koniec - Tydzień 6, wzorzec State, Joanna Kozar