package com.kodluyoruz.ecommerceconsoleapp.Services.discount;

import com.kodluyoruz.ecommerceconsoleapp.Models.cart.Cart;
import org.springframework.stereotype.Service;

@Service
public interface Discount {
    boolean isAcceptable(Cart cart);
    void applyDiscount(Cart cart);
}
