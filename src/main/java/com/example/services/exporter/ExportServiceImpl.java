package com.example.services.exporter;

// Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
// Implementacja interfejsu ExportService, który zawiera metody eksportu do CSV, PDF i XML.
public class ExportServiceImpl implements ExportService{
    @Override
    public void exportCSV(String data) {
        System.out.println("Eksport do CSV: " + data);
    }

    @Override
    public void exportPDF(String data) {
        System.out.println("Eksport do PDF: " + data);
    }

    @Override
    public void exportXML(String data) {
        System.out.println("Eksport do XML: " + data);
    }
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
