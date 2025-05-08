package com.example.services.notification.isp.split;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Interfejs AccountingNotifier odpowiedzialny za powiadamianie działu księgowości
public interface AccountingNotifier {
    void sendReportToAccounting(String reportData);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
