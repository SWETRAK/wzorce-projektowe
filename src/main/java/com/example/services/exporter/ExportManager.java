package com.example.services.exporter;

import com.example.models.books.Book;

import java.util.HashMap;
import java.util.Map;

// Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
// Klasa odpowiedzialna za dobór odpowiedniego eksportera w zależności od podanych informacji
public class ExportManager {

    private final Map<ExporterType, Exporter> exporters;

    public ExportManager() {
        this(new HashMap<>() {{
            put(ExporterType.CSV, new CSVExporter());
            put(ExporterType.XML, new XMLExporter());
        }});
    }

    public ExportManager(Map<ExporterType, Exporter> exporters) {
        this.exporters = exporters;
    }

    public void export(ExporterType exporterType, Book book) {
        Exporter exporter = exporters.get(exporterType);
        if (exporter != null) {
            exporter.visitBook(book);
        } else {
            System.out.println("Unsupported format: " + exporterType);
        }
    }
}

// Koniec, Tydzień 7, Zasada OCP, Kamil Pietrak