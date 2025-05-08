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

- [x] **Single Responsibility Principle**
  - [x] Klasa `PromotionNotifier` – odpowiada tylko za wysyłkę powiadomień o promocjach
  - [x] Klasa `UserProfileManager` – odpowiada tylko za edycję danych użytkownika
  - [x] Klasa `PaymentValidator` – odpowiada tylko za walidację płatności

- [x] **Open/Closed Principle**
  - [x] `PromotionEngine`
    - Abstrakcja: Interfejs `PromotionRule` + różne klasy z logiką promocji
    - Sterowanie danymi: lista reguł jako dane wejściowe (`List<PromotionRule>`)
  - [x] `PaymentMethod`
    - Abstrakcja: Klasa bazowa `PaymentMethod` rozszerzana przez `CreditCard`, `BLIK`
    - Sterowanie danymi: wybór metody przez string/fabrykę
  - [x] `UserNotification`
    - Abstrakcja: interfejs `Notifier` (np. EmailNotifier, SMSNotifier)
    - Sterowanie danymi: mapowanie typu notyfikacji na klasę (`Map<String, Notifier>`)


### Maciej

- [x] **Single Responsibility Principle**
  - [x] Klasa `OrderProcessor` – przetwarza tylko zamówienia
  - [x] Klasa `BookSorter` – odpowiada tylko za sortowanie książek
  - [x] Klasa `ClientHistoryManager` – odpowiada za zapis i odtwarzanie danych klienta

- [x] **Open/Closed Principle**
  - [x] `OrderHandler`
    - Abstrakcja: `OrderHandler` jako interfejs z `PhysicalOrder`, `DigitalOrder`
    - Sterowanie danymi: wybór przez typ zamówienia (np. enum)
  - [x] `SortingStrategy`
    - Abstrakcja: różne implementacje `SortingStrategy` (po cenie, dacie, popularności)
    - Sterowanie danymi: wybór strategii przez mapę strategii
  - [x] `InvoiceExporter`
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


---

## Tydzień 8

### Joanna
 

- [ ] Zasada Podstawienia Liskov (LSP)
  - [ ] Klasa bazowa: `User`
  - [ ] Klasa pochodna: `AdminUser`
  - [ ] Przykład użycia: lista użytkowników `List<User>` zawierająca również `AdminUser`
 
- [ ] Zasada Odwrócenia Zależności (DIP)
  - [ ] Interfejs: `NotificationSender`
  - [ ] Klasa abstrakcyjna: `BaseNotifier`
  - [ ] Implementacja: `EmailNotifier`
  - [ ] Moduł wysokopoziomowy: `NotificationService` używa tylko `NotificationSender`

[ ] Zasada Segregacji Interfejsów (ISP)
- [ ] Gruby interfejs: `UserOperations`
- [ ] Podział interfejsów:
  - `LoginCapability`
  - `ProfileEditing`
  - `UserStatistics`

  
### Maciej

- [ ] Zasada Podstawienia Liskov (LSP)
  - [ ] Klasa bazowa: `Order`
  - [ ] Klasa pochodna: `SpecialDiscountOrder`
  - [ ] Przykład użycia: `List<Order>` obsługuje `SpecialDiscountOrder` bez błędów

- [ ] Zasada Odwrócenia Zależności (DIP)
  - [ ] Interfejs: `PaymentProcessor`
  - [ ] Klasa abstrakcyjna: `AbstractPaymentHandler`
  - [ ] Implementacja: `CreditCardProcessor`
  - [ ] Klasa `CheckoutService` używa tylko `PaymentProcessor`

- [ ] Zasada Segregacji Interfejsów (ISP)
  - [ ] Gruby interfejs: `OrderManagement`
  - [ ] Podział interfejsów:
    - `OrderCreation`
    - `OrderTracking`
    - `OrderCancellation`


### Kamil

- [ ] Zasada Podstawienia Liskov (LSP)
  - [ ] Klasa bazowa: `Exporter`
  - [ ] Klasa pochodna: `JSONExporter`
  - [ ] Przykład użycia: `List<Exporter>` współpracuje z wszystkimi implementacjami

- [ ] Zasada Odwrócenia Zależności (DIP)
  - [ ] Interfejs: `SearchProvider`
  - [ ] Klasa abstrakcyjna: `AbstractSearchEngine`
  - [ ] Implementacja: `ElasticSearchEngine`
  - [ ] Klasa `SearchService` korzysta z `SearchProvider`, nie z konkretnego silnika

- [ ] Zasada Segregacji Interfejsów (ISP)
  - [ ] Gruby interfejs: `ExportCapabilities`
  - [ ] Podział interfejsów:
    - `PDFExport`
    - `CSVExport`
    - `XMLExport`

---

# NOWE

# Tydzień 8 – SOLID: LSP, DIP, ISP – Zadania indywidualne (Księgarnia Internetowa)

## Joanna

### 🔷 Zasada Podstawienia Liskov (LSP)
- [ ] `Book` → `EBook`, `PrintedBook`  
  (używane wymiennie w katalogu książek)
- [ ] `User` → `RegularUser`, `PremiumUser`  
  (wspólna obsługa konta i rabatów)
- [ ] `PaymentMethod` → `CardPayment`, `BLIKPayment`  
  (proces płatności)

### 🔷 Zasada Odwrócenia Zależności (DIP)
- [ ] Interfejsy: `PaymentProcessor`, `UserNotifier`, `BookSource`
- [ ] Abstrakcje: `AbstractPaymentService`, `AbstractNotifier`, `AbstractBookFetcher`
- [ ] Implementacje: `StripeProcessor`, `EmailNotifier`, `LocalDatabaseBookFetcher`
- [ ] Klasa `OrderService` korzysta tylko z abstrakcji, nie implementacji

### 🔷 Zasada Segregacji Interfejsów (ISP)
- [ ] Grube interfejsy:
  - `UserService` (logowanie, rejestracja, historia zakupów, zmiana hasła)
  - `BookService` (wyszukiwanie, filtrowanie, dodawanie, edycja, usuwanie)
  - `OrderService` (tworzenie zamówienia, anulowanie, status)
- [ ] Podzielone interfejsy:
  - `AuthenticationService`, `AccountManagement`, `HistoryService`
  - `BookSearch`, `BookEditor`
  - `OrderCreator`, `OrderStatusViewer`

## Maciej

### 🔷 Zasada Podstawienia Liskov (LSP)
- [X] `Discount` → `PercentageDiscount`, `FixedDiscount`  
  (mechanizm rabatów)
- [X] `Notification` → `EmailNotification`, `SMSNotification`  
  (system powiadomień)
- [X] `Invoice` → `PDFInvoice`, `HTMLInvoice`  
  (generowanie faktur)

### 🔷 Zasada Odwrócenia Zależności (DIP)
- [x] Interfejsy: `InvoiceGenerator`, `DiscountStrategy`, `NotificationService`
- [x] Abstrakcje: `BaseInvoiceGenerator`, `BaseDiscount`, `BaseNotifier`
- [x] Implementacje: `SimplePDFInvoice`, `LoyaltyDiscount`, `TwilioNotifier`
- [x] Klasa `CheckoutProcessor` działa tylko na interfejsach i abstrakcjach

### 🔷 Zasada Segregacji Interfejsów (ISP)
- [x] Grube interfejsy:
  - `InvoiceService` (generowanie, zapis, wysyłka)
  - `DiscountManager` (obliczanie, przydzielanie, logowanie rabatu)
  - `Notifier` (powiadom klienta, admina, księgowość)
- [x] Podzielone interfejsy:
  - `InvoiceRenderer`, `InvoiceSaver`, `InvoiceSender`
  - `DiscountApplier`, `DiscountLogger`
  - `CustomerNotifier`, `AdminNotifier`

## Kamil

### 🔷 Zasada Podstawienia Liskov (LSP)
- [ ] `DeliveryStrategy` → `CourierDelivery`, `LockerDelivery`  
  (dostawa zamówień)
- [ ] `BookSearchStrategy` → `WarehouseSearch`, `DatabaseSearch`  
  (wyszukiwanie książek)
- [ ] `Exporter` → `CSVExporter`, `PDFExporter`  
  (eksport danych księgarni)

### 🔷 Zasada Odwrócenia Zależności (DIP)
- [ ] Interfejsy: `BookRepository`, `DeliveryService`, `InvoiceRenderer`
- [ ] Abstrakcje: `AbstractBookStorage`, `AbstractDelivery`, `AbstractInvoiceRenderer`
- [ ] Implementacje: `MySQLBookRepo`, `DHLDeliveryService`, `SimplePDFRenderer`
- [ ] Klasa `OrderProcessor` operuje wyłącznie na abstrakcjach

### 🔷 Zasada Segregacji Interfejsów (ISP)
- [ ] Grube interfejsy:
  - `ExportService` (eksport książek, zamówień, faktur)
  - `SearchService` (szukaj po autorze, tytule, ISBN, magazynie)
  - `DeliveryManager` (planuj, wyślij, śledź)
- [ ] Podzielone interfejsy:
  - `BookExport`, `OrderExport`, `InvoiceExport`
  - `TitleSearch`, `AuthorSearch`, `ISBNSearch`, `LocationSearch`
  - `DeliveryPlanner`, `PackageShipper`, `TrackingService`

