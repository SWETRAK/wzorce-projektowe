package com.example.models.users;

public class Client {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String paymentMethod;
    private final String phoneNumber;
    private final String address;

    Client(String firstName, String lastName, String email, String paymentMethod, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void printInfoString() {
        System.out.println("Client: " + firstName + " " + lastName + " (" + email + ")");
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Tydzień 1, Wzorzec builder, Kamil Pietrak
    // Implementacja klasy Builder dla klasy Client, wymaga ona, aby użytkownik podał imię, nazwisko, email (pola obowiązkowe)
    // natomiast reszta parametrów jest opcjonalna
    public static class Builder {

        private final String firstName;
        private final String lastName;
        private final String email;
        private String paymentMethod;
        private String phoneNumber;
        private String address;

        public Builder(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Client build() {
            return new Client(firstName, lastName, email, paymentMethod, phoneNumber, address);
        }
    }
    // Koniec, Tydzień 1, Wzorzec builder, Kamil Pietrak
}
