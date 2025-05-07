package com.example.isp.models;

// Tydzień 8, Model danych, Kamil Pietrak
// Klasa Location reprezentująca lokalizację książki w magazynie.
public class Location {
    private final String warehouse;
    private final String aisle;
    private final String shelf;

    public Location(String warehouse, String aisle, String shelf) {
        this.warehouse = warehouse;
        this.aisle = aisle;
        this.shelf = shelf;
    }

    // Gettery
    public String getWarehouse() { return warehouse; }
    public String getAisle() { return aisle; }
    public String getShelf() { return shelf; }
}
//Koniec, Tydzień 8, Model danych (Location)