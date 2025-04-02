package com.example.services.customer;

// Tydzień 5, Wzorzec Mediator, Maciej Potręć
// Klasa reprezentująca konsultanta w systemie obsługi klienta
public class Consultant implements ServiceComponent {
    private final CustomerServiceMediator mediator;
    private final String name;

    public Consultant(CustomerServiceMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.registerComponent(this);
    }

    @Override
    public void receiveQuery(String query, String customerId) {
        System.out.println("Consultant: Handling query for customer " + customerId);

        String knowledgeBaseInfo = mediator.searchKnowledgeBase(query);

        String resolution = "I've resolved your issue regarding: " + query;
        if (!knowledgeBaseInfo.isEmpty()) {
            resolution += " (with help from our knowledge base)";
        }

        System.out.println("Consultant: " + resolution);
        mediator.notifyResolution(customerId, resolution);
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
