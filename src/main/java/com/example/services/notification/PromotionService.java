package com.example.services.notification;

import java.util.ArrayList;
import java.util.List;

//Tydzień 6, wzorzec Observer, Joanna Kozar
//Implementacja serwisu promocji
public class PromotionService {
    private final List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String promo) {
        for (Observer observer : observers) {
            observer.update(promo);
        }
    }
}

//Koniec - Tydzień 6, wzorzec Observer, Joanna Kozar
