package com.kodluyoruz.ecommerceconsoleapp.Models.pages;


import com.kodluyoruz.ecommerceconsoleapp.Models.cart.Cart;
import com.kodluyoruz.ecommerceconsoleapp.Models.checkout.Bill;
import com.kodluyoruz.ecommerceconsoleapp.Models.checkout.BillItem;
import com.kodluyoruz.ecommerceconsoleapp.Models.enums.PaymentType;
import com.kodluyoruz.ecommerceconsoleapp.Models.properties.CreditCartProperties;
import com.kodluyoruz.ecommerceconsoleapp.Models.properties.DeliveryProperties;
import com.kodluyoruz.ecommerceconsoleapp.Services.discount.DiscountStrategy;
import com.kodluyoruz.ecommerceconsoleapp.Services.payment.PaymentFactory;
import com.kodluyoruz.ecommerceconsoleapp.Services.payment.PaymentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class PaymentPage {
    private final Scanner scanner;
    private final Cart cart;
    private final CreditCartProperties creditCartProperties;
    private final DeliveryProperties deliveryProperties;
    private final DiscountStrategy discountStrategy;
    private final PaymentFactory paymentFactory;

    public void startPayment(){

        discountStrategy.applyDiscount(cart);

        for ( int i = 0; i < cart.getCartItems().size(); i ++ ) {
            System.out.println("Unit Price of " +cart.getCartItems().get(i).getProduct().getProductName());
            System.out.println(cart.getCartItems().get(i).getUnitPrice());
            System.out.println("Discounted Price of " +cart.getCartItems().get(i).getProduct().getProductName());
            System.out.println(cart.getCartItems().get(i).getDiscountedPrice());

        }
        System.out.println("Total Discounted Price : " +cart.cartDiscountedTotalPrice(cart));



        System.out.println("How do you want to Pay?\n1.Cash\n2.CreditCart");
        System.out.println("**************************");
        int paymentChoice = scanner.nextInt();

        Bill bill = new Bill();
        if (paymentChoice == 1) {

            BillItem billItem = BillItem.builder()
                    .price(cart.cartTotalPrice())
                    .appliedCommission(0)
                    .deliveredFee(deliveryProperties.getDeliveryFee())
                    .totalCost(deliveryProperties.getDeliveryFee()+cart.cartDiscountedTotalPrice(cart))
                    .build();


            System.out.println(billItem);

            PaymentInterface payment = paymentFactory.getPaymentMethod(PaymentType.CASH);
            payment.pay(bill);

        } else if (paymentChoice == 2) {

            BillItem billItem = BillItem.builder()
                    .price(cart.cartTotalPrice())
                    .appliedCommission(creditCartProperties.getCreditCartCommission())
                    .deliveredFee(deliveryProperties.getDeliveryFee())
                    .totalCost(creditCartProperties.getCreditCartCommission()+deliveryProperties.getDeliveryFee()+cart.cartDiscountedTotalPrice(cart))
                    .build();


            System.out.println(billItem);

            PaymentInterface payment = paymentFactory.getPaymentMethod(PaymentType.CREDITCART);
            payment.pay(bill);
        }
    }
}
