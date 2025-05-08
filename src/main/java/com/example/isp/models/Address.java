package com.example.isp.models;

// Tydzień 8, Model danych, Kamil Pietrak
// Klasa Address reprezentująca adres dostawy.
public class Address {
    private final String street;
    private final String city;
    private final String postalCode;
    private final String country;

    public Address(String street, String city, String code, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = code;
        this.country = country;
    }

    // Gettery
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }
}
//Koniec, Tydzień 8, Model danych (Address)