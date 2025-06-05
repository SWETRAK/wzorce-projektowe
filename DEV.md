# System księgarni

Projekt w języku JAVA w wersji SDK 17. Projekt przedstawia implementacje wzorców projektowych oraz zasad pisania czystego kodu na przykładzie systemu Księgarni internetowej.

 ---

## Tydzień 2

### Joanna

- [x] **Builder** -> Muzyka `AlbumBuilder`
- [x] **Singleton** -> Drukarka `Printer`
- [x] **Factory** -> Muzyka `AlbumFactory`
- [x] **Prototype** -> Muzyka -> Wszystkie pliki w pakiecie `com.example.models.albums`

### Maciej

- [x] **Builder** -> Książki `Book` (76 -118)
- [x] **Singleton** -> Serwis fakturowania `InvoicingService`
- [x] **Factory** -> Filmy -> wszystkie pliki w pakiecie `com.example.models.movies`
- [x] **Prototype** -> Filmy -> wszystkie pliki w pakiecie `com.example.models.movies`

### Kamil

- [x] **Builder** -> Klienci `Client` (58-91)
- [x] **Singleton** -> Dyrektor `Manager`
- [x] **Factory** -> Magazyn/Gazety -> wszystkie pliki w pakiecie `package com.example.models.papers`
- [x] **Prototype** -> Magazyn/Gazety -> wszystkie pliki w pakiecie `package com.example.models.papers`

---

## Tydzień 3

### Joanna
- [x] **Adapter** → System płatności -> Pliki w pakiecie `com.example.services.payment`
- [x] **Composite** → System kategorii książek -> Pliki w pakiecie `com.example.models.books` (`Book`, `BookComponent`, `Category`)
- [x] **Bridge** → Mechanizm rekomendacji -> Pliki w pakiecie `com.example.services.recommendation` (`RecommendationStrategy`, `PurchaseHistoryRecommendation`, `UserRatingRecommendation`, `RecommendationEngine`)
- [x] **Decorator** → System recenzji -> Pliki w pakiecie `com.example.services.review`

### Maciej
- [x] **Adapter** → Zewnętrzny dostawca książek -> Pliki w pakiecie `com.example.services.books` 
- [x] **Composite** → Koszyk zakupowy -> Pliki w pakiecie `com.example.models.cart`
- [x] **Bridge** → System powiadomień -> Pliki w pakiecie `com.example.services.notification` (`NotificationSender`, `EmailNotificationSender`, `PushNotificationSender`, `SMSNotificationSender`)
- [x] **Decorator** → System zamówień -> Pliki w pakiecie `com.example.services.order` (`Order`, `OrderDecorator`, `ExpressDeliveryDecorator`, `GiftWrappingDecorator`)

### Kamil
- [x] **Adapter** → System dostaw -> Pliki w pakiecie `com.example.services.delivery`
- [x] **Composite** → System rabatów -> Pliki w pakiecie `com.example.models.discount`
- [x] **Bridge** → Obsługa wersji książek -> Pliki w pakiecie `com.example.models.books` (`AudioBook`, `BookFormat`, `Ebook`, `PhysicalBook`)
- [x] **Decorator** → Personalizacja wyświetlania książek -> Pliki w pakiecie `com.example.services.display`

---

## Tydzień 4

### Joanna
- [x] **Facade** → System rekomendacji (ukrywanie złożoności algorytmów rekomendacji) `RecommendationFacade`
- [x] **Proxy** → Zdalny dostęp do API wydawnictwa (ograniczanie liczby zapytań) -> Pliki w pakiecie `com.example.services.publisher`
- [x] **Flyweight** → Optymalizacja przechowywania danych o autorach książek (wielokrotne użycie tych samych obiektów) `AuthorFactory`


### Maciej
- [x] **Facade** → Obsługa zamówienia (zarządzanie płatnością, wysyłką i fakturą przez jeden interfejs) -> Pliki w pakiecie `com.example.services.order.facade`
- [x] **Proxy** → Ochrona dostępu do systemu rabatów (np. limitowane oferty dla wybranych klientów) -> Pliki w pakiecie `com.example.models.discount.proxy`
- [x] **Flyweight** → Przechowywanie danych o recenzjach użytkowników (często powtarzające się oceny, tagi) -> Pliki w pakiecie `com.example.services.review.flyweight`


### Kamil
- [x] **Facade** → Zarządzanie kontem użytkownika (zmiana danych, historia zakupów, zapisane książki)  `UserAccountService`
- [x] **Proxy** → Buforowanie wyników wyszukiwania książek (zmniejszenie obciążenia bazy danych) -> Pliki w pakiecie `com.example.services.books` (`BookSearchEngine`, `BookSearch`, `WarehauseBookSearch`, `DatabaseBookSearch`)
- [x] **Flyweight** → Przechowywanie informacji o dostawach (kurier, statusy przesyłek) `DeliveryInfo`, `DeliveryFactory`, 

---

## Tydzień 5

### Joanna
- [x] **Command** → System zarządzania rabatami (dodawanie/usuwanie kuponów, aktywacja promocji) `ActivatePromotionCommand`, `DiscountCommand`, `AddCouponCommand`,  
- [x] **Interpreter** → Prosty język zapytań dla rekomendacji książek (np. `GENRE:Fantasy AND RATING>4.5`) -> Pliki w pakiecie `com.example.services.recommendation` (`Expression`, `AndExpression`, `GenreExpression`, `RatingExpression`, `BookRecommendationContext`)
- [x] **Iterator** → Iteracja po historii zakupów użytkownika -> Pliki w pakiecie `com.example.services.purchase`
- [x] **Mediator** → Zarządzanie powiadomieniami (e-mail, SMS, push) `PushNotificationSender`, `NotificationCoordinator`, `NotificationMediator`, 


### Maciej
- [x] **Command** → System obsługi zamówień (operacje na zamówieniach: anulowanie, zatwierdzanie, zwroty) -> Pliki w pakiecie `com.example.services.order.command`
- [x] **Interpreter** → Analiza recenzji użytkowników (np. analiza sentymentu poprzez proste reguły) -> Pliki w pakiecie `com.example.services.review.interpreter`
- [x] **Iterator** → Przechodzenie po wynikach wyszukiwania książek `BookSearchIterator`, `BookSearchResultIterator`
- [x] **Mediator** → System obsługi klienta (koordynacja między chatbotem, konsultantem i bazą wiedzy) -> Pliki w pakiecie `com.example.services.customer`


### Kamil
- [x] **Command** → Operacje na koszyku (dodanie/usunięcie książki, finalizacja zakupu) -> Pliki w pakiecie `com.example.services.cart`
- [x] **Interpreter** → Parsowanie zapytań filtrujących książki (np. `PRICE<50 AND AUTHOR:Rowling`) -> Pliki w pakiecie `com.example.services.books.interpreter`
- [x] **Iterator** → Iteracja po książkach w koszyku użytkownika `ShoppingCart` (38-54), `CartIterator` 
- [x] **Mediator** → Obsługa procesu dostawy (koordynacja między systemem zamówień, magazynem i firmą kurierską) -> Pliki w pakiecie `com.example.services.delivery.mediator`

---

## Tydzień 6

### Joanna

- [x] **Observer** – Powiadamianie klientów o promocjach `Client` (97 - 101), `Observer`, `PromotionService`
- [x] **State** – Stan konta użytkownika -> Pliki w pakiecie `com.example.models.accountstate`
- [x] **Strategy** – Promocje zależne od typu klienta `PromotionCalculator`, `DiscountStrategy`, `RegularCustomerStrategy`, `VipCustomerStrategy`
- [x] **Template** – Procesy płatności (karta, przelew, blik) `PaymentTemplate`, `BlikPaymentTemplate`, `PayPalPaymentTemplate`, `CardPaymentTemplate` 


- [x] **Visitor** – Raportowanie danych produktów `ProductVisitor`, `ReportGenerator`, `Book` (120-126)
- [x] **Memento** – Historia edycji książki przez administratora `BookMemento`, `Book` (128-138)

### Maciej

- [x] **Observer** – Subskrypcje magazynów/gazet -> Pliki w pakiecie `com.example.services.subscription`
- [x] **State** – Stan realizacji zamówienia -> PLiki w pakiecie `com.example.services.order.state`
- [x] **Strategy** – Sortowanie książek (data, autor, gatunek, itp...) -> Pliki w pakiecie `com.example.services.books.strategy`
- [x] **Template** – Obsługa różnych typów zamówień (papier, e-book) -> Pliki w pakiecie `com.example.services.order.template`


- [x] **Visitor** – Walidacja danych użytkownika i zamówień -> Pliki w pakiecie `com.example.services.validation`
- [x] **Memento** – Cofanie zmian w koszyku zakupowym -> Pliki w pakiecie `com.example.models.cart.memento`

### Kamil

- [x] **Observer** – Aktualizacja stanu magazynowego `StockObserver`, `WarechouseObserver`, `StockSystem`
- [x] **State** – Proces rejestracji użytkownika -> Pliki w pakiecie `com.example.services.user.register` i pod pakietach
- [x] **Strategy** – Wybór sposobu dostawy -> Pliki w pakiecie `com.example.services.delivery.startegies`
- [x] **Template** – Różne procesy wysyłki `DHLServiceAdapter` (43 - 68), `InPostServiceAdapter` (32 - 43), `DeliveryComponent` (21 - 35)


- [x] **Visitor** – Eksport danych (CSV, XML, PDF) `Exportable`, `Book` (62 - 68), `CSVExporter`, `XMLExporter`, `Exporter`
- [x] **Memento** – Historia edycji danych klienta `Client` (43-53), `ClientMemento`, `ClientCaretaker`

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

- [x] Zasada Podstawienia Liskov (LSP)
  - [x] `Book` → `EBook`, `PrintedBook` 
  - [x] `User` → `RegularUser`, `PremiumUser` 
  - [x] `PaymentMethod` → `CardPayment`, `BLIKPayment`

- [x] Zasada Odwrócenia Zależności (DIP)
  - [x] Interfejsy: `PaymentProcessor`, `UserNotifier`, `BookSource`
  - [x] Abstrakcje: `AbstractPaymentService`, `AbstractNotifier`, `AbstractBookFetcher`
  - [x] Implementacje: `StripeProcessor`, `EmailNotifier`, `LocalDatabaseBookFetcher`
  - [x] Klasa `OrderService` korzysta tylko z abstrakcji, nie implementacji

- [x] Zasada Segregacji Interfejsów (ISP)
  - [x] Grube interfejsy:
    - `UserService` (logowanie, rejestracja, historia zakupów, zmiana hasła)
    - `BookService` (wyszukiwanie, filtrowanie, dodawanie, edycja, usuwanie)
    - `OrderService` (tworzenie zamówienia, anulowanie, status)
  - [x] Podzielone interfejsy:
    - `AuthenticationService`, `AccountManagement`, `HistoryService`
    - `BookSearch`, `BookEditor`
    - `OrderCreator`, `OrderStatusViewer`

### Maciej

- [x]  Zasada Podstawienia Liskov (LSP)
  - [X] `Discount` → `PercentageDiscount`, `FixedDiscount` 
  - [X] `Notification` → `EmailNotification`, `SMSNotification` 
  - [X] `Invoice` → `PDFInvoice`, `HTMLInvoice`

- [x]  Zasada Odwrócenia Zależności (DIP)
  - [x] Interfejsy: `InvoiceGenerator`, `DiscountStrategy`, `NotificationService`
  - [x] Abstrakcje: `BaseInvoiceGenerator`, `BaseDiscount`, `BaseNotifier`
  - [x] Implementacje: `SimplePDFInvoice`, `LoyaltyDiscount`, `TwilioNotifier`
  - [x] Klasa `CheckoutProcessor` działa tylko na interfejsach i abstrakcjach

- [x] Zasada Segregacji Interfejsów (ISP)
  - [x] Grube interfejsy:
    - `InvoiceService`
    - `DiscountManager`
    - `Notifier`
  - [x] Podzielone interfejsy:
    - `InvoiceRenderer`, `InvoiceSaver`, `InvoiceSender`
    - `DiscountApplier`, `DiscountLogger`
    - `CustomerNotifier`, `AdminNotifier`

### Kamil

- [x] Zasada Podstawienia Liskov (LSP)
  - [x] `DeliveryStrategy` → `CourierDelivery`, `LockerDelivery`  
    (dostawa zamówień)
  - [x] `BookSearchStrategy` → `WarehouseSearch`, `DatabaseSearch`  
    (wyszukiwanie książek)
  - [x] `Exporter` → `CSVExporter`, `PDFExporter`  
    (eksport danych księgarni)

- [x] Zasada Odwrócenia Zależności (DIP)
  - [x] Interfejsy: `BookRepository`, `DeliveryService`, `InvoiceRenderer`
  - [x] Abstrakcje: `AbstractBookStorage`, `AbstractDelivery`, `AbstractInvoiceRenderer`
  - [x] Implementacje: `MySQLBookRepo`, `DHLDeliveryService`, `SimplePDFRenderer`
  - [x] Klasa `OrderProcessor` operuje wyłącznie na abstrakcjach

- [x] Zasada Segregacji Interfejsów (ISP)
  - [x] Grube interfejsy:
    - `ExportService`
    - `SearchService`
    - `DeliveryManager`
  - [x] Podzielone interfejsy:
    - `BookExport`, `OrderExport`, `InvoiceExport`
    - `TitleSearch`, `AuthorSearch`, `ISBNSearch`, `LocationSearch`
    - `DeliveryPlanner`, `PackageShipper`, `TrackingService`

---

## Tydzień 9

Wymagania dotyczące tego tygodnia zostały zaimplementowane w całości projektu. Wykonano refactor kodu, tak aby spełniał zasady clean code związane z nazewnictwem, powtarzalnością kodu oraz "magic number".

---

## Tydzień 10

### Joanna 

- `BookFormatter`
- `UserNotifier`
- `DiscountCalculator`

Implementacje oraz reszta wymagań z tego tygodnia dostępna w `JKTest`

### Maciej 

- `StockValidator`
- `EmailSender`
- `ShoppingCartManager`

Implementacje oraz reszta wymagań z tego tygodnia dostępna w `MPTest`

### Kamil
 
- `BookProcessor`
- `DeliveryNotifier`
- `InvoiceValidator`

Implementacje oraz reszta wymagań z tego tygodnia dostępna w `KPTest`

---

## Tydzień 12

### Joanna

 - `SongTest`
 - `PromotionEngineTest`
 - `NotificationCoordinatorTest`
 - `PurchaseHistoryTest`


### Maciej

 - `BookTest`
 - `ShoppingCartTest`
 - `EnhancedBookSorterTest`
 - `OrderProcessorTest`


### Kamil

 - `ClientTest`
 - `ExportManagerTest`
 - `CaretakerTest`
 - `DHLServiceAdapterTest`
