package com.kodluyoruz.ecommerceconsoleapp;

import com.kodluyoruz.ecommerceconsoleapp.Models.pages.MainPage;
import com.kodluyoruz.ecommerceconsoleapp.Models.pages.PaymentPage;
import com.kodluyoruz.ecommerceconsoleapp.Models.pages.SearchPage;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;




import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Demo implements CommandLineRunner {
    private final Scanner scanner;
    private final MainPage mainPage;
    private final PaymentPage paymentPage;
    private final SearchPage searchPage;

    @Override
    public void run(String... args) throws Exception {


        while (true) {
            System.out.println("**************************");
            System.out.println("Welcome to Kodluyoruz Shop\n1.Categories\n2.Search Menu\n3.Quit");
            System.out.println("**************************");
            int pageNumber = scanner.nextInt();
            scanner.nextLine();
            if (pageNumber == 1) {
                mainPage.startMenu();
                int choice = scanner.nextInt();
                if (choice == 1) {
                    paymentPage.startPayment();
                    break;
                }

            } else if (pageNumber == 2) {
                searchPage.startSearch();

            } else if (pageNumber == 3) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}






