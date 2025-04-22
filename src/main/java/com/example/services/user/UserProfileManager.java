package com.example.services.user;

// Tydzień 7, Single Responsibility Principle, Joanna Kozar
// Klasa odpowiada tylko za edycję danych użytkownika

public class UserProfileManager {
    public void updateUserProfile(String firstName, String lastName, String newFirstName, String newLastName) {
        System.out.println("Aktualizuję profil użytkownika: " + firstName + " " + lastName + " z danymi: " + newFirstName + " " + newLastName);
    }
}
//Koniec -  Tydzień 7, Single Responsibility Principle, Joanna Kozar