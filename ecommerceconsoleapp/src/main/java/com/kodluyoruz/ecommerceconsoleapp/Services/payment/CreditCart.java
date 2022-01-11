package com.kodluyoruz.ecommerceconsoleapp.Services.payment;


import com.kodluyoruz.ecommerceconsoleapp.Models.checkout.Bill;
import com.kodluyoruz.ecommerceconsoleapp.Models.enums.PaymentType;
import com.kodluyoruz.ecommerceconsoleapp.Models.properties.CreditCartProperties;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class CreditCart implements PaymentInterface{
    private CreditCartProperties creditCartProperties;


    @Override
    public void pay(Bill bill) {
        System.out.println("PAYMENT SUCCEED!");

    }

    @Override
    public PaymentType getType() {
        return PaymentType.CREDITCART;
    }
}
