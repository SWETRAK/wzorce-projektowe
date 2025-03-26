package com.example.models.discount.proxy;

import com.example.models.users.Client;
import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Proxy, Maciej Potręć
// Proxy dla zniżek z mechanizmem cachowania wyników
public class DiscountServiceProxy implements DiscountService {
    private final DiscountService realDiscountService;
    private final Map<String, Double> discountCache = new HashMap<>();

    public DiscountServiceProxy(DiscountService realDiscountService) {
        this.realDiscountService = realDiscountService;
    }

    @Override
    public double applyDiscount(Client client, double originalPrice, String discountCode) {
        String cacheKey = client.getEmail() + ":" + originalPrice + ":" + discountCode;

        if (discountCache.containsKey(cacheKey)) {
            System.out.println("Using cached discount result for " + client.getEmail() + " with code " + discountCode);
            return discountCache.get(cacheKey);
        }

        double discountedPrice = realDiscountService.applyDiscount(client, originalPrice, discountCode);

        discountCache.put(cacheKey, discountedPrice);

        return discountedPrice;
    }

    @Override
    public boolean isDiscountAvailable(Client client, String discountCode) {
        return realDiscountService.isDiscountAvailable(client, discountCode);
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy, Maciej Potręć
