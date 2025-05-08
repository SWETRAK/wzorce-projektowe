package com.example.tests.week8;


import com.example.models.discount.PriceDiscount;
import com.example.services.checkout.CheckoutProcessor;
import com.example.services.discount.dip.DiscountStrategy;
import com.example.services.discount.dip.LoyaltyDiscount;
import com.example.services.discount.isp.split.DiscountApplierImpl;
import com.example.services.discount.isp.split.DiscountLoggerImpl;
import com.example.services.discount.isp.split.DiscountServiceImpl;
import com.example.services.discount.isp.thick.DiscountManagerImpl;
import com.example.services.discount.lsp.FixedDiscount;
import com.example.services.discount.lsp.PercentageDiscount;
import com.example.services.invoice.CSVInvoiceExporter;
import com.example.services.invoice.InvoiceExporter;
import com.example.services.invoice.PDFInvoiceExporter;
import com.example.services.invoice.XMLInvoiceExporter;
import com.example.services.invoice.dip.InvoiceGenerator;
import com.example.services.invoice.dip.SimplePDFInvoice;
import com.example.services.invoice.isp.split.InvoiceGeneratorImpl;
import com.example.services.invoice.isp.split.InvoiceSenderImpl;
import com.example.services.invoice.isp.thick.InvoiceServiceImpl;
import com.example.services.notification.EmailNotifier;
import com.example.services.notification.Notifier;
import com.example.services.notification.SMSNotifier;
import com.example.services.notification.dip.TwilioNotifier;
import com.example.services.notification.isp.split.NotificationService;
import com.example.services.notification.isp.thick.NotifierImpl;
import com.example.services.order.BasicOrder;
import com.example.services.order.Order;

import java.util.ArrayList;
import java.util.List;

public class MPTests {

    public static void main(String[] args) {
        testLSP();
        testISP();
        testDIP();
    }

    private static void testLSP() {
        System.out.println("\n--- LSP Discount Test ---");

        List<PriceDiscount> discounts = new ArrayList<>();
        discounts.add(new PercentageDiscount(0.10));
        discounts.add(new FixedDiscount(5.0));

        double originalPrice = 100.0;

        for (PriceDiscount discount : discounts) {
            discount.applyDiscount(originalPrice);
            System.out.println("Original Price: $" + originalPrice +
                    ", Discount Applied: " + discount.getClass().getSimpleName() +
                    ", Sale Price: $" + discount.getSalePrice());
        }

        System.out.println("\n--- LSP Notification Test ---");

        List<Notifier> notificationServices = new ArrayList<>();
        notificationServices.add(new EmailNotifier());
        notificationServices.add(new SMSNotifier());

        String recipient = "user@example.com";
        String message = "Your order has been shipped!";

        for (Notifier service : notificationServices) {
            service.send(recipient, message);
        }

        System.out.println("\n--- LSP Invoice Test ---");

        List<InvoiceExporter> invoices = new ArrayList<>();
        invoices.add(new CSVInvoiceExporter());
        invoices.add(new PDFInvoiceExporter());
        invoices.add(new XMLInvoiceExporter());

        BasicOrder basicOrder = new BasicOrder("ORD-001", 99.99);

        for (InvoiceExporter invoice : invoices) {
            invoice.exportInvoice(basicOrder, "path/");
            System.out.println("---");
        }
    }

    private static void testISP() {
        System.out.println("\n--- ISP Invoice Test ---");

        System.out.println("\n--- Thick ---");
        InvoiceServiceImpl invoiceService = new InvoiceServiceImpl();
        Order order = new BasicOrder("ORD-001", 99.99);
        invoiceService.generateInvoice(order);
        invoiceService.saveInvoice(order, "Invoice Data");
        invoiceService.sendInvoice(order, "test@gmail.com");

        System.out.println("\n--- Split ---");

        InvoiceGeneratorImpl invoiceGenerator = new InvoiceGeneratorImpl();
        invoiceGenerator.generateInvoice(order);
        invoiceGenerator.saveInvoice(order, "Invoice Data");

        InvoiceSenderImpl invoiceSender = new InvoiceSenderImpl();
        invoiceSender.sendInvoice(order, "test@gmail.com");

        System.out.println("\n--- ISP Notification Test ---");

        System.out.println("\n--- Thick ---");
        NotifierImpl notifier = new NotifierImpl();
        notifier.notifyCustomer("1", "Your order has been shipped!");
        notifier.notifyAccounting( "Invoice for order 1");
        notifier.notifyAdmin("1", "New order received");

        System.out.println("\n--- Split ---");
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotificationToCustomer("1", "Your order has been shipped!");
        notificationService.alertAdmin("Alarm");
        notificationService.sendReportToAccounting("Report");

        System.out.println("\n--- ISP Discount Test ---");

        System.out.println("\n--- Thick ---");

        DiscountManagerImpl discountManager = new DiscountManagerImpl();
        discountManager.calculateDiscount("1",100);
        discountManager.applyDiscount("1", 10);
        discountManager.logDiscountApplication("1", "1", 10);

        System.out.println("\n--- Split ---");

        DiscountApplierImpl discountApplier = new DiscountApplierImpl();
        DiscountLoggerImpl discountLogger = new DiscountLoggerImpl();
        DiscountServiceImpl discountService = new DiscountServiceImpl(discountApplier, discountLogger);
        discountService.calculateDiscount("1", 100);
        discountService.applyDiscountToOrder("1", 10);
        discountService.logDiscount("1", "1", 10, 100);
    }

    private static void testDIP() {
        System.out.println("\n--- DIP Test ---");

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor(
                new SimplePDFInvoice(new TwilioNotifier()),
                new LoyaltyDiscount(0.05),
                new TwilioNotifier()
        );

        Order order = new BasicOrder("ORD-001", 99.99);
        checkoutProcessor.processCheckout("1", order);

    }

}
