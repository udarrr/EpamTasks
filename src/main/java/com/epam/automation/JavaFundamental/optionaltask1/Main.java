package com.epam.automation.JavaFundamental.optionaltask1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        while(true) {
            ArrayCreator arr = new ArrayCreator();
            String[] arrNumbers = arr.createAndFillArr();
            String[] initialArr = Arrays.copyOf(arrNumbers, arrNumbers.length);

            ArraySorter arraySorter = new ArraySorter();
            AvgLengthArray avgLengthArray = new AvgLengthArray();
            DifferenceNumber differenceNumber = new DifferenceNumber();

            System.out.println("Less is: " + differenceNumber.getLowerOrBiggerNumber(arrNumbers)[0] +
                    " and length is: " + differenceNumber.getLowerOrBiggerNumber(arrNumbers)[0].length() +
                    " Big is: " + differenceNumber.getLowerOrBiggerNumber(arrNumbers)[1] +
                    " and length is : " + differenceNumber.getLowerOrBiggerNumber(arrNumbers)[1].length() +
                    " Task №1");

            System.out.println("Sorted array of numbers increase: " +
                    Arrays.toString(arraySorter.getSortedNumbers(arrNumbers)) +
                    " Task №2");

            System.out.println("Sorted array of numbers decrease: " +
                    Arrays.toString(arraySorter.SortOfNumbersReverse(arrNumbers)) +
                    " Task №2");

            System.out.println("Numbers with less avg length: " +
                    Arrays.toString(avgLengthArray.getAmountNumbersWithLessAvgLengthThanLengthAllNumbers(arrNumbers))
                    + " and their length:" + Arrays.toString(avgLengthArray.getLengthArrayOfNumbers(avgLengthArray.getAmountNumbersWithLessAvgLengthThanLengthAllNumbers(arrNumbers))) + " Task №3");

            System.out.println("Numbers with more avg length: " +
                    Arrays.toString(avgLengthArray.getAmountNumbersWithMoreAvgLengthThanLengthAllNumbers(arrNumbers))
                    + " and their length:" + Arrays.toString(avgLengthArray.getLengthArrayOfNumbers(avgLengthArray.getAmountNumbersWithMoreAvgLengthThanLengthAllNumbers(arrNumbers))) + " Task №3");

            System.out.println("First number with less differences is: " + differenceNumber.getNumberWithMinimumVariousNumbers(initialArr) + " Task №4");

            System.out.println("Number with only odd number is: " + differenceNumber.OddNumber(initialArr) +
                    " and number with half odd and even numbers is: " + differenceNumber.OddAndEvenHalfNumber(initialArr) + " Task №5");

            System.out.println("First increase number with strict orders is: " + differenceNumber.IncreaseNumberOrder(initialArr) + " Task №6");

            System.out.println("Firs max difference number is: " + differenceNumber.MaxDifferenceNumber(initialArr) + " Task №7");

            System.out.println("********** Try again **********");
        }
    }
}
