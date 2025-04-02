package com.example.tests.week5;

import com.example.services.discount.*;
import com.example.services.notification.*;
import com.example.services.purchase.*;
import com.example.services.recommendation.*;

public class JKTests {
    public static void main(String[] args) {
        // Command - zarządzanie rabatami
        DiscountManager discountManager = new DiscountManager();
        DiscountCommand addCoupon = new AddCouponCommand(discountManager, "BLACKFRIDAY");
        DiscountCommand activatePromo = new ActivatePromotionCommand(discountManager);
        addCoupon.execute();
        activatePromo.execute();

        // Interpreter - język zapytań dla rekomendacji
        Expression filter = new AndExpression(new GenreExpression("Fantasy"), new RatingExpression(4.5));
        BookRecommendationContext bookContext = new BookRecommendationContext("Fantasy", 4.7);
        System.out.println("Czy książka spełnia warunki? " + filter.interpret(bookContext));

        // Iterator - historia zakupów
        PurchaseHistory history = new PurchaseHistory();
        history.addPurchase("Władca Pierścieni");
        history.addPurchase("Harry Potter");
        PurchaseIterator iterator = history.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Kupiona książka: " + iterator.next());
        }

        //Mediator - powiadomienia
        EmailNotificationSender emailSender = new EmailNotificationSender();
        SMSNotificationSender smsSender = new SMSNotificationSender();
        PushNotificationSender pushSender = new PushNotificationSender();

        // Tworzenie i konfiguracja mediatora
        NotificationCoordinator mediator = new NotificationCoordinator();
        mediator.register(emailSender);
        mediator.register(smsSender);
        mediator.register(pushSender);

        // Wysyłanie powiadomień przez mediatora
        System.out.println("\n# Pojedyncze powiadomienia:");
        mediator.sendNotification("email", "jan.kowalski@example.com", "Promocja", "Nowa promocja na książki");
        mediator.sendNotification("sms", "+48123456789", "Nowa książka", "Twoja zamówiona książka jest już dostępna");
        mediator.sendNotification("push", "device-id-abc123", "Przypomnienie", "Masz nieoddaną książkę");

        // Wysyłanie powiadomień wieloma kanałami
        System.out.println("\n# Powiadomienie wieloma kanałami:");
        mediator.broadcastNotification(
                new String[]{"email", "sms"},
                "anna.nowak@example.com",
                "Status zamówienia",
                "Twoje zamówienie #54321 zostało wysłane"
        );



    }
}

