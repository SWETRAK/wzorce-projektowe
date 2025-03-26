package com.example.models.discount.proxy;

import com.example.models.discount.PriceDiscount;
import com.example.models.users.Client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Tydzień 4, Wzorzec Proxy, Maciej Potręć
// Rzeczywista implementacja usługi rabatowej
public class RealDiscountService implements DiscountService {
    private final Map<String, PriceDiscount> discountCodes = new HashMap<>();
    private final Map<String, Set<String>> eligibleClients = new HashMap<>();

    public void registerDiscount(String discountCode, PriceDiscount discount) {
        discountCodes.put(discountCode, discount);
        eligibleClients.putIfAbsent(discountCode, new HashSet<>());
    }

    public void registerDiscount(String discountCode, PriceDiscount discount, Set<String> clientEmails) {
        discountCodes.put(discountCode, discount);
        eligibleClients.put(discountCode, new HashSet<>(clientEmails));
    }

    public void addEligibleClient(String discountCode, String clientEmail) {
        if (discountCodes.containsKey(discountCode)) {
            eligibleClients.computeIfAbsent(discountCode, k -> new HashSet<>()).add(clientEmail);
        }
    }

    public boolean isClientEligible(Client client, String discountCode) {
        if (!discountCodes.containsKey(discountCode)) {
            return false;
        }

        Set<String> eligibleClientEmails = eligibleClients.get(discountCode);
        if (eligibleClientEmails.isEmpty()) {
            return true;
        }

        return eligibleClientEmails.contains(client.getEmail());
    }

    @Override
    public double applyDiscount(Client client, double originalPrice, String discountCode) {
        if (isClientEligible(client, discountCode)) {
            discountCodes.get(discountCode).applyDiscount(originalPrice);
            return discountCodes.get(discountCode).getSalePrice();
        }
        return originalPrice;
    }

    @Override
    public boolean isDiscountAvailable(Client client, String discountCode) {
        return discountCodes.containsKey(discountCode) && isClientEligible(client, discountCode);
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy, Maciej Potręć
