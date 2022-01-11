package com.kodluyoruz.ecommerceconsoleapp.Categories;


import com.kodluyoruz.ecommerceconsoleapp.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SubCategory extends MainCategory {
    private String subName;
    private List<Product> productList=new ArrayList<>();

    public SubCategory(String mainName, String subName) {
        super(mainName);
        this.subName = subName;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return subName;

    }
}

