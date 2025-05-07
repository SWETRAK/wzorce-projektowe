package com.example.isp.abstractons;

import com.example.isp.models.ExportFormat;
import com.example.services.invoice.renderer.Invoice;

public interface InvoiceExport {
    void exportInvoice(Invoice invoice, ExportFormat format);
}
