package com.example.services.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Tydzień 12, Testy jednostkowe, Joanna Kozar
// Klasa testowa dla NotificationCoordinator, która sprawdza różne funkcjonalności koordynatora powiadomień
class NotificationCoordinatorTest {

    @Mock
    private EmailNotificationSender emailSender;

    @Mock
    private SMSNotificationSender smsSender;

    @Mock
    private PushNotificationSender pushSender;

    private NotificationCoordinator coordinator;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        coordinator = new NotificationCoordinator();

        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    //Test sprawdza rejestrację i wysyłanie powiadomienia email
    @Test
    void shouldRegisterAndSendEmailNotification() {
        coordinator.register(emailSender);
        String recipient = "test@example.com";
        String subject = "Test Subject";
        String content = "Test Content";

        coordinator.sendNotification("email", recipient, subject, content);

        verify(emailSender, times(1)).sendNotification(recipient, subject, content);

        System.setOut(originalOut);
    }

    //Test sprawdza rejestrację i wysyłanie powiadomienia SMS
    @Test
    void shouldRegisterAndSendSMSNotification() {
        coordinator.register(smsSender);
        String recipient = "+48123456789";
        String subject = "SMS";
        String content = "Message";

        coordinator.sendNotification("sms", recipient, subject, content);

        verify(smsSender, times(1)).sendNotification(recipient, subject, content);

        System.setOut(originalOut);
    }

    //Test sprawdza rejestrację i wysyłanie powiadomienia push
    @Test
    void shouldRegisterAndSendPushNotification() {
        coordinator.register(pushSender);
        String recipient = "user123";
        String subject = "New Message";
        String content = "You have a new notification";

        coordinator.sendNotification("push", recipient, subject, content);

        verify(pushSender, times(1)).sendNotification(recipient, subject, content);

        System.setOut(originalOut);
    }

    //Test sprawdza obsługę nieznanego typu powiadomienia i wyświetlenie odpowiedniego komunikatu
    @Test
    void shouldHandleUnknownNotificationType() {
        coordinator.register(emailSender);
        String recipient = "test@example.com";
        String subject = "Test";
        String content = "Content";

        coordinator.sendNotification("unknown", recipient, subject, content);

        String output = outputStream.toString().trim();
        assertEquals("Nieznany typ powiadomienia: unknown", output);

        verify(emailSender, never()).sendNotification(anyString(), anyString(), anyString());

        System.setOut(originalOut);
    }

    //Test sprawdza funkcjonalność broadcast - wysyłanie powiadomienia wieloma kanałami jednocześnie
    @Test
    void shouldBroadcastNotificationToMultipleChannels() {
        coordinator.register(emailSender);
        coordinator.register(smsSender);
        coordinator.register(pushSender);

        String[] types = {"email", "sms", "push"};
        String recipient = "user@example.com";
        String subject = "Broadcast Alert";
        String content = "Important message for all channels";

        coordinator.broadcastNotification(types, recipient, subject, content);

        verify(emailSender, times(1)).sendNotification(recipient, subject, content);
        verify(smsSender, times(1)).sendNotification(recipient, subject, content);
        verify(pushSender, times(1)).sendNotification(recipient, subject, content);

        System.setOut(originalOut);
    }
}
//Koniec - Tydzień 12, Testy jednostkowe, Joanna Kozar