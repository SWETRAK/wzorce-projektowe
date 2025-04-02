package com.example.services.customer;

import java.util.HashMap;
import java.util.Map;

// Tydzień 5, Wzorzec Mediator, Maciej Potręć
// Klasa reprezentująca bazę wiedzy w systemie obsługi klienta
public class KnowledgeBase implements ServiceComponent {
    private final CustomerServiceMediator mediator;
    private final String name;
    private final Map<String, String> articles = new HashMap<>();

    public KnowledgeBase(CustomerServiceMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.registerComponent(this);
        initializeKnowledgeBase();
    }

    private void initializeKnowledgeBase() {
        articles.put("return", "Books can be returned within 30 days with receipt.");
        articles.put("shipping", "Standard shipping takes 3-5 business days.");
        articles.put("payment", "We accept credit cards, PayPal, and gift cards.");
        articles.put("ebook", "Ebooks can be downloaded up to 5 times.");
    }

    public String getAnswer(String query) {
        String lowerQuery = query.toLowerCase();

        for (Map.Entry<String, String> entry : articles.entrySet()) {
            if (lowerQuery.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return "";
    }

    @Override
    public void receiveQuery(String query, String customerId) {
        sendQuery(query, customerId);
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