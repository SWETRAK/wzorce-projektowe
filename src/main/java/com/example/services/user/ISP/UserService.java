package com.example.services.user.ISP;

// Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
//Gruby interfejs UserService
public interface UserService {
    void login(String username, String password);
    void register(String username, String password);
    void viewHistory();
    void changePassword(String oldPass, String newPass);
}
// Koniec - Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar