package com.example.services.cart;

import com.example.models.cart.CartItem;
import com.example.models.cart.ShoppingCart;

// Tydzień 5, Wzorzec Command, Kamil Pietrak
// Interfejs dla komend operujących na koszyku
public class AddToCartCommand implements CartCommand {
    private ShoppingCart cart;
    private CartItem cartItem;

    public AddToCartCommand(ShoppingCart cart, CartItem cartItem) {
        this.cart = cart;
        this.cartItem = cartItem;
    }

    @Override
    public void execute() {
        cart.addItem(cartItem);
    }

    @Override
    public void undo() {
        cart.removeItem(cartItem);
    }
}
// Koniec, Tydzień 5, Wzorzec Command, Kamil Pietrak
