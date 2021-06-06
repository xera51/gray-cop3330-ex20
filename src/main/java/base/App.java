/*
 *  UCF COP3330 Summer 2021 Exercise 20 Solution
 *  Copyright 2021 Christopher Gray
 */
package base;

import java.util.Scanner;

public class App {

    static Scanner in = new Scanner(System.in);

    static final double WI_TAX_RATE = 0.05;
    static final double WI_EAU_CLAIRE_TAX_RATE = 0.005;
    static final double WI_DUNN_TAX_RATE = 0.004;
    static final double IL_TAX_RATE = 0.08;

    public static void main(String[] args) {
        App myApp = new App();

        int orderAmount = myApp.readOrderAmount();
        String state = myApp.readState();
        String county = myApp.readCounty();

        String output = myApp.generateOutputString(orderAmount, state, county);
        myApp.displayOutput(output);
    }

    private int readOrderAmount() {
        System.out.print("What is the order amount? ");
        return Integer.parseInt(in.nextLine());
    }

    private String readState() {
        System.out.print("What state do you live in? ");
        return in.nextLine();
    }

    private String readCounty() {
        System.out.print("What county do you live in? ");
        return in.nextLine();
    }

    public String generateOutputString(double orderAmount, String state, String county) {
        double tax_rate = 0;
        double tax = 0;

        if(state.equals("Wisconsin")) {
            tax_rate = WI_TAX_RATE;
            if(county.equals("Eau Claire")) {
                tax_rate += WI_EAU_CLAIRE_TAX_RATE;
            } else if (county.equals("Dunn")) {
                tax_rate += WI_DUNN_TAX_RATE;
            }
            tax = roundToNearestCent(calculateTax(orderAmount, tax_rate));
        } else if (state.equals("Illinois")) {
            tax_rate = IL_TAX_RATE;
            tax = roundToNearestCent(calculateTax(orderAmount, tax_rate));
        }
        double total = roundToNearestCent(orderAmount + (orderAmount * tax_rate));

        return String.format("The tax is $%.2f.%nThe total is $%.2f.",
                tax, total);
    }

    private static double calculateTax(double orderAmount, double taxRate) {
        return orderAmount * taxRate;
    }

    public static double roundToNearestCent(double in) {
        return Math.ceil(in * 100.0 - 0.00000001) / 100.0;
    }

    public void displayOutput(String output) { System.out.println(output); }
}
