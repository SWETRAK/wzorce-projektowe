package com.example.models.discount.proxy;

import com.example.models.users.Client;

// Tydzień 4, Wzorzec Proxy, Maciej Potręć
// Interfejs serwisu rabatów
public interface DiscountService {
    double applyDiscount(Client client, double originalPrice, String discountCode);
    boolean isDiscountAvailable(Client client, String discountCode);
}
// Koniec, Tydzień 4, Wzorzec Proxy, Maciej Potręć
