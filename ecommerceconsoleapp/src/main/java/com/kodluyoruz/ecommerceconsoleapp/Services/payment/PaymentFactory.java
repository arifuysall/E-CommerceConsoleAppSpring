package com.kodluyoruz.ecommerceconsoleapp.Services.payment;


import com.kodluyoruz.ecommerceconsoleapp.Models.enums.PaymentType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaymentFactory {

    private final Map<PaymentType,PaymentInterface> paymentMap;

    public PaymentFactory(List<PaymentInterface> paymentList) {
        paymentMap = paymentList.stream()
                .collect(Collectors.toMap(PaymentInterface::getType, paymentMethod->paymentMethod));

    }

    public PaymentInterface getPaymentMethod(PaymentType type){
        return paymentMap.get(type);
    }


}

