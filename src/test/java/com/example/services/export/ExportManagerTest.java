package com.example.services.export;

import com.example.models.books.Book;
import com.example.services.exporter.ExportManager;
import com.example.services.exporter.Exporter;
import com.example.services.exporter.ExporterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

// Tydzień 12, Testy jednostkowe, Kamil Pietrak
// Klasa testowa dla Export Manager
class ExportManagerTest {

    private ExportManager exportManager;
    private Book mockBook;
    private Exporter csvExporter;
    private Exporter xmlExporter;

    @BeforeEach
    void setUp() {
        mockBook = mock(Book.class);
        csvExporter = mock(Exporter.class);
        xmlExporter = mock(Exporter.class);

        Map<ExporterType, Exporter> exporters = new HashMap<>();
        exporters.put(ExporterType.CSV, csvExporter);
        exporters.put(ExporterType.XML, xmlExporter);

        exportManager = new ExportManager(exporters);
    }

    @Test
    void shouldUseCSVExporterForCSVType() {
        exportManager.export(ExporterType.CSV, mockBook);
        verify(csvExporter, times(1)).visitBook(mockBook);
    }

    @Test
    void shouldUseXMLExporterForXMLType() {
        exportManager.export(ExporterType.XML, mockBook);
        verify(xmlExporter, times(1)).visitBook(mockBook);
    }

    @Test
    void shouldNotThrowWhenExporterIsMissing() {
        ExportManager managerWithEmptyMap = new ExportManager(new HashMap<>());
        managerWithEmptyMap.export(ExporterType.CSV, mockBook);
    }

    @Test
    void shouldAllowNullBookWithoutException() {
        exportManager.export(ExporterType.CSV, null);
        verify(csvExporter, times(1)).visitBook(null);
    }

    @Test
    void shouldNotCallExporterWhenTypeIsUnknown() {
        Map<ExporterType, Exporter> onlyCSV = new HashMap<>();
        onlyCSV.put(ExporterType.CSV, csvExporter);
        ExportManager manager = new ExportManager(onlyCSV);

        manager.export(ExporterType.XML, mockBook);
        verifyNoInteractions(xmlExporter);
        verify(csvExporter, never()).visitBook(any());
    }
}

// Koniec, Tydzień 12, Testy jednostkowe, Kamil Pietrak
