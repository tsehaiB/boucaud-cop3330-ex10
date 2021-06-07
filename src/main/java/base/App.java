/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Tsehai Boucaud
 */
package base;
import java.util.Scanner;
public class App {
    Scanner inp = new Scanner(System.in);
    final static double taxRate = 5.5;
    public static void main(String[] args)
    {
        App myApp = new App();
        int[] prices = new int[3];
        int[] quantities = new int[3];
        double total = 0;
        for(int i = 0; i < 3; i++) {
            prices[i] = myApp.readPrice("price", i);
            quantities[i] = myApp.readPrice("quantities", i);
            total = myApp.subTotal(prices[i], quantities[i], total);
        }
        System.out.printf("Subtotal: $%.2f\n", total);
        System.out.printf("Tax: $%.2f\n", myApp.calcTax(total));
        System.out.printf("Total: $%.2f\n", myApp.total(total, myApp.calcTax(total)));

    }
    private double calcTax(double total){
        return total * (taxRate / 100.0);
    }
    private double total(double total, double tax){
        return total + tax;
    }
    private double subTotal(int price, int quantity, double total){
        return total + (price * quantity);
    }
    private int readPrice(String word, int i){
        System.out.print("Enter the " + word + " of item " + (i+1) + ": ");
        return Integer.parseInt(inp.nextLine());
    }
}
