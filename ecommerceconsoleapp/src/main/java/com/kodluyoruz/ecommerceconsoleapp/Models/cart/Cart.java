package com.kodluyoruz.ecommerceconsoleapp.Models.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Cart {
    private final List<CartItem> cartItems;



    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(CartItem cartItem){
        cartItems.add(cartItem);
    }

    public double cartTotalPrice(){
        double cartTotal = 0;
        for (CartItem cartItem : cartItems ) {
            cartTotal = cartTotal + cartItem.getTotalPrice();
        }
        return cartTotal;
    }

    public List<CartItem> getCartItems(){
        return cartItems;
    }

    public double cartDiscountedTotalPrice(Cart cart){
        double cartDiscountedPrice = 0;
        for (CartItem cartItem : cartItems){
            cartDiscountedPrice += cartItem.getDiscountedPrice();
        }
        return cartDiscountedPrice;
    }
}
