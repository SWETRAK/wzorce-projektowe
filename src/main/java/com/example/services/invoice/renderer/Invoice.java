package com.example.services.invoice.renderer;

import java.util.List;

// Tydzień 8, Model danych, Kamil Pietrak
// Klasa Invoice reprezentująca fakturę w systemie.
public class Invoice {
    private final String customerName;
    private final List<String> items;
    private final double total;
    
    public Invoice(String customerName, List<String> items, double total) {
        this.customerName = customerName;
        this.items = items;
        this.total = total;
    }
    
    // Gettery
    public String getCustomerName() { return customerName; }
    public List<String> getItems() { return items; }
    public double getTotal() { return total; }
}
//Koniec, Tydzień 8, Model danych 1