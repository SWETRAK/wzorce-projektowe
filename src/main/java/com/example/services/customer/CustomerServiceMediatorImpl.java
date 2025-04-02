package com.example.services.customer;

import java.util.HashMap;
import java.util.Map;

// Tydzień 5, Wzorzec Mediator, Maciej Potręć
// Klasa implementująca mediator do komunikacji między komponentami systemu obsługi klienta
public class CustomerServiceMediatorImpl implements CustomerServiceMediator {
    private ChatBot chatBot;
    private Consultant consultant;
    private KnowledgeBase knowledgeBase;
    private Map<String, String> activeQueries = new HashMap<>();

    @Override
    public void registerComponent(ServiceComponent component) {
        if (component instanceof ChatBot) {
            chatBot = (ChatBot) component;
        } else if (component instanceof Consultant) {
            consultant = (Consultant) component;
        } else if (component instanceof KnowledgeBase) {
            knowledgeBase = (KnowledgeBase) component;
        }
    }

    @Override
    public void routeQuery(ServiceComponent sender, String query, String customerId) {
        String senderName = sender != null ? sender.getName() : "Customer";
        System.out.println("Mediator: Routing query from " + senderName);
        activeQueries.put(customerId, query);

        if (sender == null || !(sender instanceof ChatBot) && !(sender instanceof Consultant)) {
            chatBot.receiveQuery(query, customerId);
        }

        else if (sender instanceof ChatBot) {
            consultant.receiveQuery(query, customerId);
        }
    }

    @Override
    public void escalateToConsultant(String query, String customerId) {
        System.out.println("Mediator: Escalating to consultant");
        consultant.receiveQuery(query, customerId);
    }

    @Override
    public String searchKnowledgeBase(String query) {
        return knowledgeBase.getAnswer(query);
    }

    @Override
    public void notifyResolution(String customerId, String resolution) {
        System.out.println("Mediator: Case resolved for customer " + customerId);
        System.out.println("Resolution: " + resolution);
        activeQueries.remove(customerId);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Maciej Potręć
