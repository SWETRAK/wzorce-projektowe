package com.example.services.notification;

//Tydzień 5, Wzorzec Mediator, Joanna Kozar
//Implementacja rozszerzenia abstrakcji z wzorca Bridge, które współpracuje z mediatorem
public class MediatedNotification extends Notification {
    private final NotificationMediator mediator;
    private final String notificationType;

    public MediatedNotification(NotificationSender sender, NotificationMediator mediator, String notificationType) {
        super(sender);
        this.mediator = mediator;
        this.notificationType = notificationType;
    }

    @Override
    public void send(String recipient) {
        // Deleguje wysyłkę do mediatora
        mediator.sendNotification(notificationType, recipient, getSubject(), getContent());
    }

    protected String getSubject() {
        return "Default Subject";
    }

    protected String getContent() {
        return "Default Content";
    }
}
//Koniec - Tydzień 5, Wzorzec Mediator, Joanna Kozar