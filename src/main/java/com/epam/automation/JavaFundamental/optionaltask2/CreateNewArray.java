package com.epam.automation.JavaFundamental.optionaltask2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CreateNewArray {

    int[][] getNewArray() {

        Random count = new Random();

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[][] arr = new int[size][size];

        for (int i = 0; i < arr.length; ++i) {

            for (int j = 0; j < arr[i].length; ++j) {

                arr[i][j] = count.nextInt(9);
            }
        }

        return arr;
    }

    int[][] getCopyOfArray(int[][] original) {

        int[][] copy = new int[original.length][];

        for (int i = 0; i < original.length; i++) {

            copy[i] = Arrays.copyOf(original[i], original.length);
        }

        return copy;
    }
}
