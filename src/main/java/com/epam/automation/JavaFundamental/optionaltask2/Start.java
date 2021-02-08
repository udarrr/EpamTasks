package com.epam.automation.JavaFundamental.optionaltask2;

import java.util.Arrays;

public class Start {

    public static void main(String[] args) {

        System.out.println("Enter n: ");

        CreateNewArray createNewArray = new CreateNewArray();

        int[][] newArray = createNewArray.getNewArray();
        int[][] unsortedArray = createNewArray.getCopyOfArray(newArray);

        System.out.println("Unsorted array is: ");

        for (int i = 0; i < newArray.length; i++) {

            System.out.println(Arrays.toString(newArray[i]));
        }

        new SortOfArrayInt().sortOfNumbers(newArray);

        System.out.println("Sorted array is: ");

        for (int i = 0; i < newArray.length; i++) {

            System.out.println(Arrays.toString(newArray[i]));
        }

        Sequences sequences = new Sequences();

        System.out.println("The longest sequences: " + Arrays.toString(sequences.getMaxLongSequences(unsortedArray)));
    }
}
