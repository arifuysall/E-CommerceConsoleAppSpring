package com.kodluyoruz.ecommerceconsoleapp.Services.payment;

import com.kodluyoruz.ecommerceconsoleapp.Models.checkout.Bill;
import com.kodluyoruz.ecommerceconsoleapp.Models.enums.PaymentType;
import org.springframework.stereotype.Service;


@Service
public interface PaymentInterface {

    void pay(Bill bill);
    PaymentType getType();


}
