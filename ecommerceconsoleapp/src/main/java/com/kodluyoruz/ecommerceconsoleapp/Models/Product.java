package com.kodluyoruz.ecommerceconsoleapp.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productName;
    private String description;
    private double price;

    @Override
    public String toString() {
        return " Name : " + productName +
                ", Detail : " + description +
                ", Price : " + price + " TL ";
    }
}
