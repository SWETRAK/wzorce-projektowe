package com.example.services.user.ISP;

// Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
//Podzielony interfejs AuthenticationService
public interface AuthenticationService {
    void login(String username, String password);
    void register(String username, String password);
}
//Koniec - Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar