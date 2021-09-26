package ex26;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Evan Verdu
 */

import java.util.Scanner;

public class PaymentCalculator {

    public static void main (String[] Args) {

        Scanner scanner = new Scanner(System.in);
        double month_cost;

        System.out.print("What is your balance? ");
        String balance = scanner.nextLine();

        System.out.print("What is the APR on the card (as a percent)? ");
        String apr = scanner.nextLine();

        System.out.print("What is the monthly payment you can make? ");
        String monthly_payment = scanner.nextLine();

        int Balance = Integer.parseInt(balance);
        double APR = Double.parseDouble(apr);
        int Monthly_Payment = Integer.parseInt(monthly_payment);

        APR = APR/100;
        month_cost = calculateMonthsUntilPaidOff(Balance, APR, Monthly_Payment);

        System.out.print("It will take you " + String.format("%.0f", month_cost) + " months to pay off this card.");

    }

    public static double calculateMonthsUntilPaidOff(int Balance, double APR, int Monthly_Payment){

            double n;
            double x = 0.03333333;
            int Bala_Pay = Balance/Monthly_Payment;

            n = Math.ceil(-x * Math.log(1 + Bala_Pay * (1 - Math.pow(1 + (APR/365), 30))) / Math.log(1 + (APR/365)));

            return n;
    }



}
