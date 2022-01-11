package com.kodluyoruz.ecommerceconsoleapp.Models.checkout;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private List<BillItem> billItems;
    private double totalPrice;
}