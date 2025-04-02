package com.example.services.customer;

// Tydzień 5, Wzorzec Mediator, Maciej Potręć
// Interfejs mediatora do komunikacji między komponentami systemu obsługi klienta
public interface CustomerServiceMediator {
    void registerComponent(ServiceComponent component);
    void routeQuery(ServiceComponent sender, String query, String customerId);
    void escalateToConsultant(String query, String customerId);
    String searchKnowledgeBase(String query);
    void notifyResolution(String customerId, String resolution);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Maciej Potręć
