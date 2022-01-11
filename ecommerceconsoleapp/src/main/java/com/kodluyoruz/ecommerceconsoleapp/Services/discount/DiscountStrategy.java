package com.kodluyoruz.ecommerceconsoleapp.Services.discount;
import com.kodluyoruz.ecommerceconsoleapp.Models.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DiscountStrategy {
    private final List<Discount> discounts;

    public void applyDiscount(Cart cart) {
        for (Discount discount: discounts) {
            if (discount.isAcceptable(cart)){
                discount.applyDiscount(cart);
                break;
            }
            }

        }
    }


