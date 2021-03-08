package com.epam.automation.javafundamental_stage1.maintask;

import java.util.Scanner;

public class Point5 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of month that you wish: ");

            String lineWithNumberOfMonth = sc.nextLine();

            int month;

            try {
                month = Integer.parseInt(lineWithNumberOfMonth);

                switch (month) {
                    case 1:
                        System.out.println("January");
                        break;
                    case 2:
                        System.out.println("February");
                        break;
                    case 3:
                        System.out.println("Mart");
                        break;
                    case 4:
                        System.out.println("April");
                        break;
                    case 5:
                        System.out.println("May");
                        break;
                    case 6:
                        System.out.println("June");
                        break;
                    case 7:
                        System.out.println("July");
                        break;
                    case 8:
                        System.out.println("August");
                        break;
                    case 9:
                        System.out.println("September");
                        break;
                    case 10:
                        System.out.println("October");
                        break;
                    case 11:
                        System.out.println("November");
                        break;
                    case 12:
                        System.out.println("December");
                        break;

                    default:
                        System.out.println("Month isn't exist");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " Wrong, you can write down only numbers:");
            }
        }
    }
}
