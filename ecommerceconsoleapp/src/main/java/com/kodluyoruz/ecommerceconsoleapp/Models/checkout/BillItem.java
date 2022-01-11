package com.kodluyoruz.ecommerceconsoleapp.Models.checkout;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillItem {
    private double price;
    private double deliveredFee;
    private double appliedCommission;
    private double totalCost;


    @Override
    public String toString() {
        return
                " Delivery Fee : " + deliveredFee +"\n"+
                " Applied Commission : " + appliedCommission +"\n"+
                " Total Cost : " + totalCost;
    }
}
