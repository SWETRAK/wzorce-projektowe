package com.example.models.users;

import lombok.Getter;

// Tydzień 2, Wzorzec singleton, Kamil Pietrak
// Statyczna metoda getInstance zwraca obiekt klasy Manager, jeśli takowy nie istnieje jeszcze w systemie to obiekt jest tworzony z odpowiednimi informacjami o menadżerze
@Getter
public class Manager {

    private static Manager INSTANCE;

    private final String firstName;
    private final String lastName;
    private final String email;

    private Manager(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public static Manager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Manager("Andrzej", "Kowalski", "andrzej.kowalski@gmail.com");
        }

        return INSTANCE;
    }

    public void printInfo() {
        System.out.println("Dyrektor: " + getFirstName() + " " + getLastName() + " (" + getEmail() + ")");
    }
}
// Koniec, Tydzień 2, Wzorzec singleton, Kamil Pietrak
