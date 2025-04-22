package com.example.services.books;

// Tydzień 7, Zasada SRP, Kamil Pietrak
// Klasa odpowiedzialna tylko za aktualizację stanu magazynu
public class StockUpdater {
    private final WarehouseBookRepository warehouseBookRepository;

    public StockUpdater(WarehouseBookRepository warehouseBookRepository) {
        this.warehouseBookRepository = warehouseBookRepository;
    }

    public void updateStock(String productId, int newQuantity) {
        warehouseBookRepository.saveStock(productId, newQuantity);
        System.out.println("Stock updated for " + productId);
    }
}
// Koniec, Tydzień 7, Zasada SRP, Kamil Pietrak