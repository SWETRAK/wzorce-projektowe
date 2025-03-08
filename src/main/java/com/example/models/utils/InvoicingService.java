package com.example.models.utils;

// Tydzień 1, Wzorzec Singleton, Maciej Potręć
// Wzorzec ten pozwala na stworzenie tylko jednej instancji danej klasy
public class InvoicingService {
    private static InvoicingService instance;

    private InvoicingService() {
    }

    public static InvoicingService getInstance() {
        if (instance == null) {
            instance = new InvoicingService();
        }
        return instance;
    }

    public void printInvoice(String invoiceDetails) {
        System.out.println("Printing Invoice:");
        System.out.println("----------------------------");
        System.out.println(invoiceDetails);
        System.out.println("Invoice printed successfully!\n");
    }
}
// Koniec, Wzorzec Singleton, Maciej Potręć
