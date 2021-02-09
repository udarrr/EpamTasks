package com.epam.automation.JavaFundamental.optionaltask2;

import java.util.Arrays;

public class Start {

    public static void main(String[] args) {

        System.out.println("Enter n: ");

        int[][] newArray = ArrayCreator.getNewArray();
        int[][] unsortedArray = ArrayCreator.getCopyOfArray(newArray);

        System.out.println("Unsorted array is: ");

        for (int i = 0; i < newArray.length; i++) {

            System.out.println(Arrays.toString(newArray[i]));
        }

        ArraySorter.sortOfNumbers(newArray);

        System.out.println("Sorted array is: ");

        for (int i = 0; i < newArray.length; i++) {

            System.out.println(Arrays.toString(newArray[i]));
        }

        System.out.println("The longest sequences: " + Arrays.toString(Sequences.getMaxLongSequences(unsortedArray)));

        System.out.println("The sum all lines in one line" + Arrays.toString(ArraySum.sumLinesArray(newArray)));
    }
}
