package com.example.models.users;

import com.example.services.notification.Observer;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Client implements Observer {

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    @Setter
    private String email;

    private final String paymentMethod;
    private final String phoneNumber;
    private final String address;

    public Client(String firstName, String lastName, String email, String paymentMethod, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void printInfo() {
        System.out.println("Client: " + firstName + " " + lastName + " (" + email + ")");
    }

    // Tydzień 2, Wzorzec builder, Kamil Pietrak
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
    // Koniec, Tydzień 2, Wzorzec builder, Kamil Pietrak


    // Tydzień 6, wzorzec Observer, Joanna Kozar
    // Implementacja wzorca Observer w klasie klienta w celu powiadamiania go o promocjach
    @Override
    public void update(String promo) {
        System.out.println(firstName + lastName + " otrzymał powiadomienie o promocji: " + promo);
    }
    // Koniec - Tydzień 6, wzorzec Observer, Joanna Kozar

}
