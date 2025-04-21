package com.example.services.books;

// Tydzień 7, Zasada SRP, Kamil Pietrak
// Klasa odpowiedzialna tylko za aktualizację stanu magazynu
public class StockUpdater {
    private final WarehouseRepository warehouseRepository;

    public StockUpdater(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public void updateStock(String productId, int newQuantity) {
        warehouseRepository.saveStock(productId, newQuantity);
        System.out.println("Stock updated for " + productId);
    }
}
// Koniec, Tydzień 7, Zasada SRP, Kamil Pietrak