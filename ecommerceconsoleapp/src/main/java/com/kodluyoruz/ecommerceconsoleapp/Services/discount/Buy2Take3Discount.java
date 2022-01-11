package com.kodluyoruz.ecommerceconsoleapp.Services.discount;

import com.kodluyoruz.ecommerceconsoleapp.Models.cart.Cart;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Data
public class Buy2Take3Discount implements Discount {
    @Override
    public void applyDiscount(Cart cart) {
        for ( int i = 0; i < cart.getCartItems().size();i++){
            if(cart.getCartItems().get(i).getQuantity()>=3){
                double discount = cart.getCartItems().get(i).getProduct().getPrice() *
                        ((double)cart.getCartItems().get(i).getQuantity() / 3);
                double appliedDiscount = (cart.getCartItems().get(i).getProduct().getPrice()*cart.getCartItems().get(i).getQuantity()) - discount;
                cart.getCartItems().get(i).setAppliedDiscount(appliedDiscount);
            }
        }
    }

    @Override
    public boolean isAcceptable(Cart cart) {
        List<String> productNames = new ArrayList<>();
        for ( int i = 0; i < cart.getCartItems().size(); i++){
            String productName = cart.getCartItems().get(i).getProduct().getProductName();
            if (productNames.contains(productName)) {
                continue;
            }
            productNames.add(productName);
        }
        return productNames.size() > 5;
    }
}

