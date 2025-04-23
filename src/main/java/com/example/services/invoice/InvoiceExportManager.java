package com.example.services.invoice;

import com.example.services.order.BasicOrder;

import java.util.HashMap;
import java.util.Map;

// Tydzień 7, Zasada OC, Maciej Potręć
// Klasa odpowiadająca za zarządzanie eksportem faktur do różnych formatów.
public class InvoiceExportManager {
    private final Map<InvoiceExportFormat, InvoiceExporter> exporters = new HashMap<>();

    public InvoiceExportManager() {
        exporters.put(InvoiceExportFormat.CSV, new CSVInvoiceExporter());
        exporters.put(InvoiceExportFormat.XML, new XMLInvoiceExporter());
        exporters.put(InvoiceExportFormat.PDF, new PDFInvoiceExporter());
    }

    public void exportInvoice(BasicOrder order, String filePath, InvoiceExportFormat format) {
        InvoiceExporter exporter = exporters.get(format);
        if (exporter == null) {
            throw new IllegalArgumentException("Unsupported export format: " + format);
        }
        exporter.exportInvoice(order, filePath);
    }
}
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć
