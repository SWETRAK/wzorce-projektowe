# System księgarni

Projekt w java 17

## Aktorzy

- **Dyrektor** -> Jeden może być singletonem
- **Pracownicy** -> Wielu, wszyscy będą mieli te same uprawnienia, tylko dane osobowe i dane wynagrodzenia inne, może prototyp
- **Klienci** -> wielu, kilka informacji obowiązkowych, reszta parametrów opcjonalna, builder ???

## Produkty

- Książki -> bardzo duża liczba, kilka informacji obowiązkowych, reszta opcjonalne builder ???
- Magazyny/Gazety -> Wiele, Możemy factory zrobić tutaj
- Muzyka -> Płyty CD/ Winyle -> Factory
- Filmy -> DVD/BlueRay -> Factory

Dodatkowo każdy z produktów może być prototypem sam w sobie, bo możemy mieć np.: 10x książkę o tym samym tytule, ale o
innym id, lub inne wydanie.

## Inne obiekty

- Drukarka -> Może być singletonem, w przyszłości jakaś kolejka czy coś można dodać 
- Serwis fakturowania -> Może być singletonem, w przyszłości jakaś kolejka czy coś można dodać 
- Faktura -> Wiele, ale część danych taka sama we wszystkich, wiec można zrobić prototyp 

## Organizacja pracy

Działamy na Feature Branch, gdy zaimplementujemy swoją część robimy PR na GH i po approve od innych robimy merge do
develop, jak tydzień jest ogarnięty to robimy PR develop do main.


## Opcje na

---

## Tydzień 2

### Joanna

- [x] Builder -> Muzyka 
- [x] Singleton -> Drukarka
- [x] Factory -> Muzyka
- [x] Prototype -> Muzyka

### Maciej

- [x] Builder -> Książki
- [x] Singleton -> Serwis fakturowania
- [x] Factory -> Filmy
- [x] Prototype -> Filmy

### Kamil

- [x] Builder -> Klienci
- [x] Singleton -> Dyrektor
- [x] Factory -> Magazyn/Gazety
- [x] Prototype -> Magazyn/Gazety

---

## Tydzień 3

### **Joanna**  
- [x] **Adapter** → System płatności  
- [x] **Composite** → System kategorii książek  
- [x] **Bridge** → Mechanizm rekomendacji  
- [x] **Decorator** → System recenzji  

### **Maciej**  
- [x] **Adapter** → Zewnętrzny dostawca książek  
- [x] **Composite** → Koszyk zakupowy  
- [x] **Bridge** → System powiadomień  
- [x] **Decorator** → System zamówień  

### **Kamil**  
- [x] **Adapter** → System dostaw  
- [x] **Composite** → System rabatów  
- [x] **Bridge** → Obsługa wersji książek  
- [x] **Decorator** → Personalizacja wyświetlania książek  

---

## Tydzień 4

### **Joanna**  
- [x] **Facade** → System rekomendacji (ukrywanie złożoności algorytmów rekomendacji)
- [x] **Proxy** → Zdalny dostęp do API wydawnictwa (ograniczanie liczby zapytań)  
- [x] **Flyweight** → Optymalizacja przechowywania danych o autorach książek (wielokrotne użycie tych samych obiektów)  


### **Maciej**  
- [x] **Facade** → Obsługa zamówienia (zarządzanie płatnością, wysyłką i fakturą przez jeden interfejs)
- [x] **Proxy** → Ochrona dostępu do systemu rabatów (np. limitowane oferty dla wybranych klientów)  
- [x] **Flyweight** → Przechowywanie danych o recenzjach użytkowników (często powtarzające się oceny, tagi)  


### **Kamil**  
- [x] **Facade** → Zarządzanie kontem użytkownika (zmiana danych, historia zakupów, zapisane książki)  
- [x] **Proxy** → Buforowanie wyników wyszukiwania książek (zmniejszenie obciążenia bazy danych)  
- [x] **Flyweight** → Przechowywanie informacji o dostawach (kurier, statusy przesyłek)  

---

## Tydzień 5

### **Joanna**
- [x] **Command** → System zarządzania rabatami (dodawanie/usuwanie kuponów, aktywacja promocji)
- [x] **Interpreter** → Prosty język zapytań dla rekomendacji książek (np. `GENRE:Fantasy AND RATING>4.5`)
- [x] **Iterator** → Iteracja po historii zakupów użytkownika
- [x] **Mediator** → Zarządzanie powiadomieniami (e-mail, SMS, push)


### **Maciej**
- [x] **Command** → System obsługi zamówień (operacje na zamówieniach: anulowanie, zatwierdzanie, zwroty)
- [x] **Interpreter** → Analiza recenzji użytkowników (np. analiza sentymentu poprzez proste reguły)
- [x] **Iterator** → Przechodzenie po wynikach wyszukiwania książek
- [x] **Mediator** → System obsługi klienta (koordynacja między chatbotem, konsultantem i bazą wiedzy)


### **Kamil**
- [x] **Command** → Operacje na koszyku (dodanie/usunięcie książki, finalizacja zakupu)
- [x] **Interpreter** → Parsowanie zapytań filtrujących książki (np. `PRICE<50 AND AUTHOR:Rowling`)
- [x] **Iterator** → Iteracja po książkach w koszyku użytkownika
- [x] **Mediator** → Obsługa procesu dostawy (koordynacja między systemem zamówień, magazynem i firmą kurierską)  

---

## Tydzień 6

### Joanna

- [x] **Observer** – Powiadamianie klientów o promocjach
- [x] **State** – Stan konta użytkownika
- [x] **Strategy** – Promocje zależne od typu klienta
- [x] **Template** – Procesy płatności (karta, przelew, blik)


- [x] **Visitor** – Raportowanie danych produktów
- [x] **Memento** – Historia edycji książki przez administratora


### Maciej

- [x] **Observer** – Subskrypcje magazynów/gazet
- [x] **State** – Stan realizacji zamówienia
- [x] **Strategy** – Sortowanie książek (data, autor, gatunek, itp...)
- [x] **Template** – Obsługa różnych typów zamówień (papier, e-book)


- [x] **Visitor** – Walidacja danych użytkownika i zamówień
- [x] **Memento** – Cofanie zmian w koszyku zakupowym

### Kamil

- [x] **Observer** – Aktualizacja stanu magazynowego
- [x] **State** – Proces rejestracji użytkownika
- [x] **Strategy** – Wybór sposobu dostawy
- [x] **Template** – Różne procesy wysyłki


- [x] **Visitor** – Eksport danych (CSV, XML, PDF)
- [x] **Memento** – Historia edycji danych klienta

---

## Tydzień 7

### Joanna

- [ ] **Single Responsibility Principle**
  - [ ] Klasa `PromotionNotifier` – odpowiada tylko za wysyłkę powiadomień o promocjach
  - [ ] Klasa `UserProfileManager` – odpowiada tylko za edycję danych użytkownika
  - [ ] Klasa `PaymentValidator` – odpowiada tylko za walidację płatności

- [ ] **Open/Closed Principle**
  - [ ] `PromotionEngine`
    - Abstrakcja: Interfejs `PromotionRule` + różne klasy z logiką promocji
    - Sterowanie danymi: lista reguł jako dane wejściowe (`List<PromotionRule>`)
  - [ ] `PaymentMethod`
    - Abstrakcja: Klasa bazowa `PaymentMethod` rozszerzana przez `CreditCard`, `BLIK`
    - Sterowanie danymi: wybór metody przez string/fabrykę
  - [ ] `UserNotification`
    - Abstrakcja: interfejs `Notifier` (np. EmailNotifier, SMSNotifier)
    - Sterowanie danymi: mapowanie typu notyfikacji na klasę (`Map<String, Notifier>`)


### Maciej

- [ ] **Single Responsibility Principle**
  - [ ] Klasa `OrderProcessor` – przetwarza tylko zamówienia
  - [ ] Klasa `BookSorter` – odpowiada tylko za sortowanie książek
  - [ ] Klasa `ClientHistoryManager` – odpowiada za zapis i odtwarzanie danych klienta

- [ ] **Open/Closed Principle**
  - [ ] `OrderHandler`
    - Abstrakcja: `OrderHandler` jako interfejs z `PhysicalOrder`, `DigitalOrder`
    - Sterowanie danymi: wybór przez typ zamówienia (np. enum)
  - [ ] `SortingStrategy`
    - Abstrakcja: różne implementacje `SortingStrategy` (po cenie, dacie, popularności)
    - Sterowanie danymi: wybór strategii przez mapę strategii
  - [ ] `InvoiceExporter`
    - Abstrakcja: interfejs `Exporter` (np. CSV, PDF, XML)
    - Sterowanie danymi: wybór typu eksportu przez parametr lub konfigurację
    

### Kamil

- [x] **Single Responsibility Principle**
  - [x] `StockUpdater` – klasa odpowiedzialna wyłącznie za aktualizację stanu magazynu
  - [x] `DeliveryScheduler` – klasa zajmująca się planowaniem dostaw
  - [x] `PDFInvoiceGenerator` – odpowiada jedynie za tworzenie faktur PDF

- [x] **Open/Closed Principle**
  - [x] `Wyszukiwanie książek`
    - Abstrakcja: BookSearch.
    - Sterowanie danymi: `BookSearchManager` wybiera strategię na podstawie typu źródła (`db`, `warehouse`).
  - [x] `DeliveryStrategy`
    - Abstrakcja: interfejs + `CourierDelivery`, `LockerDelivery`
    - Sterowanie danymi: przekazanie strategii na podstawie danych użytkownika
  - [x] `Exporter`
    - Abstrakcja: `Exporter` + `CSVExporter`, `XMLExporter`
    - Sterowanie danymi: konfiguracja formatu eksportu (np. przez UI lub parametryzację)
