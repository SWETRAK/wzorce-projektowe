package com.example.isp.abstractons;

import com.example.isp.models.ExportFormat;
import com.example.services.order.Order;

public interface OrderExport {
    void exportOrder(Order order, ExportFormat format);
}
