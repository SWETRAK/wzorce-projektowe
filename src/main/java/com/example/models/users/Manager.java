package com.example.models.users;

// Tydzień 1, Wzorzec singleton, Kamil Pietrak
// Statyczna metoda getInstance zwraca obiekt klasy Manager, jeśli takowy nie istnieje jeszcze w systemie to obiekt jest tworzony z odpowiednimi informacjami o menadżerze
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

    public void printInfoString() {
        System.out.println("Dyrektor: " + getFirstName() + " " + getLastName() + " (" + getEmail() + ")");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
// Koniec, Tydzień 1, Wzorzec singleton, Kamil Pietrak
