package com.kodluyoruz.ecommerceconsoleapp.Models.pages;

import com.kodluyoruz.ecommerceconsoleapp.Categories.Categories;
import com.kodluyoruz.ecommerceconsoleapp.Categories.MainCategory;
import com.kodluyoruz.ecommerceconsoleapp.Categories.SubCategory;
import com.kodluyoruz.ecommerceconsoleapp.Models.Product;
import com.kodluyoruz.ecommerceconsoleapp.Models.cart.Cart;
import com.kodluyoruz.ecommerceconsoleapp.Models.cart.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class MainPage {
    private final Scanner scanner;
    private final Cart cart;


    public void startMenu(){

        Categories categories = new Categories();

        MainCategory fruitAndVegetable = new MainCategory("Fruit and Vegetable");
        MainCategory snack = new MainCategory("Snack");
        MainCategory breakfast = new MainCategory("Breakfast");

        SubCategory fruit = new SubCategory("Fruit and Vegetable", "Fruit");
        SubCategory vegetable = new SubCategory("Fruit and Vegetable", "Vegetable");
        SubCategory chips = new SubCategory("Snack", "Chips");
        SubCategory chocolate = new SubCategory("Snack", "Chocolate");
        SubCategory milk = new SubCategory("Breakfast", "Milk");
        SubCategory delicatessen = new SubCategory("Breakfast", "Delicatessen");

        Product apple = new Product("Apple", "test", 1.0);
        Product pear = new Product("Pear", "test", 2.5);
        Product grape = new Product("Grape", "test", 3.5);
        Product tomato = new Product("Tomato", "test", 4.5);
        Product pepper = new Product("Pepper", "test", 5.5);
        Product eggplant = new Product("Eggplant", "test", 6.5);
        Product lays = new Product("Lays", "test", 10.0);
        Product doritos = new Product("Doritos", "test", 8.5);
        Product ruffles = new Product("Ruffles", "test", 9.5);
        Product tadelle = new Product("Tadelle", "test", 10.5);
        Product albeni = new Product("Albeni", "test", 11.5);
        Product hobby = new Product("Hobby", "test", 12.5);
        Product fullfat = new Product("Full-Fat", "test", 13.5);
        Product lowfat = new Product("Low-Fat", "test", 14.5);
        Product lactofree = new Product("Lacto-Free", "test", 15.5);
        Product cheddar = new Product("Cheddar", "test", 16.5);
        Product cheese = new Product("Cheese", "test", 17.5);
        Product olive = new Product("Olive", "test", 18.5);

        categories.addCategory(fruitAndVegetable);
        categories.addCategory(snack);
        categories.addCategory(breakfast);

        fruitAndVegetable.addCategory(fruit);
        fruitAndVegetable.addCategory(vegetable);

        snack.addCategory(chips);
        snack.addCategory(chocolate);

        breakfast.addCategory(milk);
        breakfast.addCategory(delicatessen);

        fruit.addProduct(apple);
        fruit.addProduct(pear);
        fruit.addProduct(grape);

        vegetable.addProduct(tomato);
        vegetable.addProduct(pepper);
        vegetable.addProduct(eggplant);

        chips.addProduct(lays);
        chips.addProduct(doritos);
        chips.addProduct(ruffles);

        chocolate.addProduct(tadelle);
        chocolate.addProduct(albeni);
        chocolate.addProduct(hobby);

        milk.addProduct(fullfat);
        milk.addProduct(lowfat);
        milk.addProduct(lactofree);

        delicatessen.addProduct(cheddar);
        delicatessen.addProduct(cheese);
        delicatessen.addProduct(olive);



        List<MainCategory> mainCategoryList = categories.getMainCategoryList();

        System.out.println("Main Categories : ");
        System.out.println(categories.getMainCategoryList());
        System.out.println("**************************");
        String mainChoice = scanner.nextLine();

        System.out.println(mainChoice+"'s Subcategories");

        for (MainCategory mainCategory : mainCategoryList) {
            if (mainCategory.getMainName().equals(mainChoice)) {
                mainCategory.getSubCategoryList().forEach(System.out::println);
            }
        }

        System.out.println("**************************");
        String subChoice = scanner.nextLine();
        System.out.println(subChoice+"'s Products");
        System.out.println("**************************");
        for (MainCategory mainCategory : mainCategoryList){
            for ( int i = 0 ; i < mainCategoryList.size() ; i++){
                if (mainCategory.getMainName().equals(mainChoice)){
                    if(mainCategory.getSubCategoryList().get(i).getSubName().equals(subChoice)) {
                        mainCategory.getSubCategoryList().get(i).getProductList().forEach(System.out::println);
                        break;

                    }
                }
            }
        }

        System.out.println("What do you want to buy?");
        System.out.println("**************************");
        String productChoice = scanner.nextLine();
        System.out.println("How Many?");
        System.out.println("**************************");
        int quantity = scanner.nextInt();

        Product lastProduct = new Product();

        for (int i = 0; i < mainCategoryList.size(); i++) {
            for (MainCategory mainCategory1 : mainCategoryList) {
                for (SubCategory subCategory : mainCategory1.getSubCategoryList()) {
                    for (Product product : subCategory.getProductList()) {
                        if (product.getProductName().equals(productChoice)) {
                            lastProduct = product;
                        }
                    }
                }
            }
        }
        CartItem cartItem = CartItem.builder()
                .product(lastProduct)
                .quantity(quantity)
                .build();
        cart.addItem(cartItem);

        System.out.println(cart.getCartItems());
        System.out.println("Total Price of cart : " +cart.cartTotalPrice());
        System.out.println("**************************");
        System.out.println("Press 1 for Checkout or any button for to the top");
        System.out.println("**************************");
    }
}
