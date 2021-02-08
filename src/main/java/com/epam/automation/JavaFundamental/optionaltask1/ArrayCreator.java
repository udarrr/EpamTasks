package com.epam.automation.JavaFundamental.optionaltask1;

import java.util.Scanner;

public class ArrayCreator {

    String[] createAndFillArr() {

        int sizeArray = 0;
        int sizeLimit = 0;
        String[] ArrayOfNumbers = new String[0];
        boolean exit = true;

        Scanner sc = new Scanner(System.in);

        System.out.println("Set size of array ");

        while (exit) {

            try {
                String setLine = sc.nextLine();

                sizeArray = Integer.parseInt(setLine);

                ArrayOfNumbers = new String[sizeArray];

                exit = false;

                System.out.println("Enter here desired value for " + sizeArray + " numbers that will be included in array");
                System.out.println("After each number in line push enter");

            } catch (Exception e) {

                System.out.println("You can enter only integer number");
            }
        }

        while (sizeLimit < sizeArray) {

            try {
                String newNumberInLine = sc.nextLine();

                Long.parseLong(newNumberInLine);

                ArrayOfNumbers[sizeLimit] = newNumberInLine;

                sizeLimit++;

            } catch (Exception e) {
                System.out.println("You can enter only numbers please try again");
            }
        }

        return ArrayOfNumbers;
    }
}
