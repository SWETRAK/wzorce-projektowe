// Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
// Gruby interfejs ExportService zawierający wiele metod eksportu (CSV, PDF, XML).
package com.example.services.exporter;

public interface ExportService {
    void exportCSV(String data);
    void exportPDF(String data);
    void exportXML(String data);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak