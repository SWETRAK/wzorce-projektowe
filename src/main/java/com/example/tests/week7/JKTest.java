package com.example.tests.week7;

import com.example.services.discount.*;
import com.example.services.notification.UserNotification;
import com.example.services.payment.*;
import com.example.services.user.UserProfileManager;

import java.util.Arrays;

public class JKTest {
    public static void main(String[] args) {

        // Single Responsibility Principle

        System.out.println("=== Single Responsibility Principle ===");
        PromotionNotifier notifier = new PromotionNotifier();
        notifier.notifyUser("asia@example.com", "Nowa promocja na książki!");

        UserProfileManager profileManager = new UserProfileManager();
        profileManager.updateUserProfile("Joanna", "Kozar", "Asia", "Gosia");

        PaymentValidator paymentValidator = new PaymentValidator();
        boolean valid = paymentValidator.validate("Karta Visa 1234");
        System.out.println("Czy płatność jest poprawna? " + valid);

        // Open/Closed Principle

        System.out.println("\n=== Open/Closed Principle ===");
        PromotionRule vipRule = new VipPromotionRule();
        PromotionRule newUserRule = new NewUserPromotionRule();

        PromotionEngine engine = new PromotionEngine(Arrays.asList(vipRule, newUserRule));
        engine.evaluatePromotions("VIP");
        engine.evaluatePromotions("NEW");
        engine.evaluatePromotions("STANDARD");

        PaymentMethod card = new Card();
        PaymentMethod blik = new BLIK();
        PaymentMethod paypal = new PayPal();

        card.processPayment(150.00);
        blik.processPayment(75.50);
        paypal.processPayment(127.00);

        UserNotification userNotification = new UserNotification();
        userNotification.notifyUser("email", "asia@example.com", "Twoje zamówienie zostało wysłane!");
        userNotification.notifyUser("sms", "Asia123", "Twoja płatność została potwierdzona.");
        userNotification.notifyUser("push", "Asia123", "Brak powiadomienia dla push!");

        System.out.println("\n=== Test zakończony ===");
    }
}