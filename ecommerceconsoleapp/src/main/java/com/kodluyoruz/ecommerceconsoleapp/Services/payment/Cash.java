package com.kodluyoruz.ecommerceconsoleapp.Services.payment;


import com.kodluyoruz.ecommerceconsoleapp.Models.checkout.Bill;
import com.kodluyoruz.ecommerceconsoleapp.Models.enums.PaymentType;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Cash implements PaymentInterface {


    @Override
    public void pay(Bill bill) {
        System.out.println("No commission in cash.\nPAYMENT SUCCEED!");

    }

    @Override
    public PaymentType getType() {
        return PaymentType.CASH;
    }
}