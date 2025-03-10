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

## Tydzień 1

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