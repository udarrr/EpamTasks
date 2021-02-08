package com.epam.automation.JavaFundamental.maintask;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Point3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter quantity values in array");

        String randomNumber = sc.nextLine();

        System.out.println("Quantity values : " + randomNumber);

        int sizeArray = Integer.parseInt(randomNumber);

        int[] valuesArray = new int[sizeArray];

        for (int i = 0; i < sizeArray; i++) {

            int randomValue = new Random().nextInt(10);

            System.out.println(randomValue + " ");

            valuesArray[i] = randomValue;
        }

        String result = Arrays.toString(valuesArray);

        System.out.println(result);
    }
}
