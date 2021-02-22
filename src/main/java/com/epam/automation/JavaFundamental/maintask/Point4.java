package com.epam.automation.JavaFundamental.maintask;

import java.util.Scanner;

public class Point4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your number №1: ");

        String lineWithFirstNumber = scan.nextLine();

        boolean operation = true;

        double firstNumber = 0;
        double secondNumber = 0;

        try {
            firstNumber = Double.parseDouble(lineWithFirstNumber);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Wrong number №1");
            operation = false;

        }

        System.out.println("Enter your number №1: ");

        String lineWithSecondNumber = scan.nextLine();

        try {
            secondNumber = Double.parseDouble(lineWithSecondNumber);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Wrong number №2");
            operation = false;
        }

        if (operation) {
            double summa = firstNumber + secondNumber;
            System.out.println("Summa is:" + summa);

            double multiplication = firstNumber * secondNumber;
            System.out.println("Multiplication is:" + multiplication);
        } else {
            System.out.println("No result due to you enter wrong number");
        }
    }
}
