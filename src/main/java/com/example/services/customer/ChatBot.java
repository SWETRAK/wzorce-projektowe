package com.example.services.customer;

// Tydzień 5, Wzorzec Mediator, Maciej Potręć
// Klasa reprezentująca ChatBota w systemie obsługi klienta
public class ChatBot implements ServiceComponent {
    private final CustomerServiceMediator mediator;
    private final String name;

    public ChatBot(CustomerServiceMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.registerComponent(this);
    }

    @Override
    public void receiveQuery(String query, String customerId) {
        System.out.println("ChatBot: Processing query from customer " + customerId);

        String answer = mediator.searchKnowledgeBase(query);

        if (!answer.isEmpty()) {
            System.out.println("ChatBot: Found answer in knowledge base");
            System.out.println("ChatBot: Responding to customer with: " + answer);
            mediator.notifyResolution(customerId, "Resolved by chatbot: " + answer);
        } else {
            System.out.println("ChatBot: Cannot answer this query");
            mediator.escalateToConsultant(query, customerId);
        }
    }

    @Override
    public void sendQuery(String query, String customerId) {
        mediator.routeQuery(this, query, customerId);
    }

    @Override
    public String getName() {
        return name;
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Maciej Potręć
