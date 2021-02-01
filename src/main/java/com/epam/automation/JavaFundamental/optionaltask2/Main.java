package com.epam.automation.JavaFundamental.optionaltask2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter n: ");
        CreateNewMassive cn = new CreateNewMassive();
        int[][] newArr = cn.arr();
        int[][] initialArr = cn.copyOf(newArr);
        System.out.println("Unsorted array is: ");

        for(int i = 0; i < newArr.length; i++) {
             System.out.println(Arrays.toString(newArr[i]));
        }

        SortOfArrayInt sort = new SortOfArrayInt();
        sort.SortOfNumbers(newArr);
        System.out.println("Sorted array is: ");

         for(int i = 0; i< newArr.length; i++)
         {
            System.out.println(Arrays.toString(newArr[i]));
         }

        ArrayMethods meth = new ArrayMethods();
        System.out.println("The longest sequences: " + Arrays.toString(meth.SearchSequences(initialArr)));
    }
}
