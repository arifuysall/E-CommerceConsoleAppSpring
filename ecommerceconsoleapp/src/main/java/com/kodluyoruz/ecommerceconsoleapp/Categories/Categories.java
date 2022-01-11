package com.kodluyoruz.ecommerceconsoleapp.Categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@Component
public class Categories {
    private final List<MainCategory> mainCategoryList = new ArrayList<>();

    public void addCategory(MainCategory mainCategory) {
        mainCategoryList.add(mainCategory);
    }

    public List<MainCategory> getMainCategoryList() {
        return mainCategoryList;
    }

    @Override
    public String toString() {
        return "mainCategoryList=" + mainCategoryList +
                '}';
    }
}