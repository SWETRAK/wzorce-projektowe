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

## Tydzień 3


### Joanna  
- [x] **Adapter** → System płatności  
- [x] **Composite** → System kategorii książek  
- [x] **Bridge** → Mechanizm rekomendacji  
- [x] **Decorator** → System recenzji  

### Maciej  
- [x] **Adapter** → Zewnętrzny dostawca książek  
- [x] **Composite** → Koszyk zakupowy  
- [x] **Bridge** → System powiadomień  
- [x] **Decorator** → System zamówień  

### Kamil  
- [x] **Adapter** → System dostaw  
- [x] **Composite** → System rabatów  
- [x] **Bridge** → Obsługa wersji książek  
- [x] **Decorator** → Personalizacja wyświetlania książek  


## Tydzień 4


### **Joanna**  
- [ ] **Facade** → System rekomendacji (ukrywanie złożoności algorytmów rekomendacji)
- [ ] **Proxy** → Zdalny dostęp do API wydawnictwa (ograniczanie liczby zapytań)  
- [ ] **Flyweight** → Optymalizacja przechowywania danych o autorach książek (wielokrotne użycie tych samych obiektów)  


### **Maciej**  
- [ ] **Facade** → Obsługa zamówienia (zarządzanie płatnością, wysyłką i fakturą przez jeden interfejs)
- [ ] **Proxy** → Ochrona dostępu do systemu rabatów (np. limitowane oferty dla wybranych klientów)  
- [ ] **Flyweight** → Przechowywanie danych o recenzjach użytkowników (często powtarzające się oceny, tagi)  


### **Kamil**  
- [ ] **Facade** → Zarządzanie kontem użytkownika (zmiana danych, historia zakupów, zapisane książki)  
- [ ] **Proxy** → Buforowanie wyników wyszukiwania książek (zmniejszenie obciążenia bazy danych)  
- [ ] **Flyweight** → Przechowywanie informacji o dostawach (kurier, statusy przesyłek)  
