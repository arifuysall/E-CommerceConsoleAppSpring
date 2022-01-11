package com.kodluyoruz.ecommerceconsoleapp.Services.discount;

import com.kodluyoruz.ecommerceconsoleapp.Models.properties.DiscountProperties;
import com.kodluyoruz.ecommerceconsoleapp.Models.cart.Cart;
import com.kodluyoruz.ecommerceconsoleapp.Models.cart.CartItem;

import lombok.RequiredArgsConstructor;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;




@Service
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PercentageDiscount implements Discount{
    private final DiscountProperties discountProperties;

    @Override
    public void applyDiscount(Cart cart) {
        for (CartItem cartItem:cart.getCartItems()) {
            double appliedDiscount =cartItem.getTotalPrice()*((100-discountProperties.getPercentage())/100);
            cartItem.setAppliedDiscount(appliedDiscount);
        }
    }

    @Override
    public boolean isAcceptable(Cart cart) {
        return cart.cartTotalPrice() >= 1000;
    }
}
