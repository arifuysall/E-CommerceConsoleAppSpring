package com.kodluyoruz.ecommerceconsoleapp.Models.cart;
import com.kodluyoruz.ecommerceconsoleapp.Models.Product;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Product product;
    private int quantity;
    private double appliedDiscount;
    private double discountedPrice;
    private double unitPrice;


    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
    public double getUnitPrice(){
        if(appliedDiscount == 0){
            return product.getPrice();
        }
        return getDiscountedPrice()/ quantity;
    }
    public double getDiscountedPrice(){
        if(appliedDiscount == 0){
            return product.getPrice()*quantity;

        }
        return appliedDiscount;
    }

    @Override
    public String toString() {
        return  product + " Quantity : " + quantity +"\n";
    }
}
