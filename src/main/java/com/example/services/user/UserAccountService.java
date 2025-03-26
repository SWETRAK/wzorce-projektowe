package com.example.services.user;

import com.example.models.cart.CartItem;
import com.example.models.cart.ShoppingCart;
import com.example.models.cart.Wishlist;
import com.example.models.users.Client;

// Tydzień 4, Wzorzec Facade, Kamil Pietrak
// Fasada, która integruje profil klienta, koszyk i listę życzeń.
public class UserAccountService {

    private Client client;
    private ShoppingCart shoppingCart;
    private Wishlist wishlist;

    public UserAccountService(Client client) {
        this.client = client;
        this.shoppingCart = new ShoppingCart();
        this.wishlist = new Wishlist();
    }

    public void updateProfile(String newEmail, String newFirstName, String newLastName) {
        client.setEmail(newEmail);
        client.setFirstName(newFirstName);
        client.setLastName(newLastName);
    }

    public void addPurchase(CartItem item) {
        shoppingCart.addItem(item);
    }

    public void addToWishlist(CartItem item) {
        wishlist.addItem(item);
    }

    public void showAccountInfo() {
        client.printInfo();
        shoppingCart.display();
        wishlist.display();
    }
}
// Koniec, Tydzień 4, Wzorzec Facade, Kamil Pietrak