package com.epam.automation.JavaFundamental.optionaltask1;

import java.util.Arrays;

public class Start {

    public static void main(String[] args) {

        while (true) {

            ArrayCreator arr = new ArrayCreator();
            String[] arrNumbers = arr.createAndFillArr();
            String[] initialArr = Arrays.copyOf(arrNumbers, arrNumbers.length);

            ArraySorter arraySorter = new ArraySorter();
            AvgLengthArray avgLengthArray = new AvgLengthArray();
            NumbersWithDifferences numbers = new NumbersWithDifferences();

            System.out.println("Less is: " + numbers.getLowerOrBiggerNumber(arrNumbers)[0] + " and length is: " + numbers.getLowerOrBiggerNumber(arrNumbers)[0].length() + " Big is: " + numbers.getLowerOrBiggerNumber(arrNumbers)[1] + " and length is : " + numbers.getLowerOrBiggerNumber(arrNumbers)[1].length() + " Task №1");

            System.out.println("Sorted array of numbers increase: " + Arrays.toString(arraySorter.getSortedNumbers(arrNumbers)) + " Task №2");

            System.out.println("Sorted array of numbers decrease: " + Arrays.toString(arraySorter.sortOfNumbersReverse(arrNumbers)) + " Task №2");

            System.out.println("Numbers with less avg length: " + Arrays.toString(avgLengthArray.getAmountNumbersWithLessAvgLengthThanLengthAllNumbers(arrNumbers)) + " and their length:" + Arrays.toString(avgLengthArray.getLengthArrayOfNumbers(avgLengthArray.getAmountNumbersWithLessAvgLengthThanLengthAllNumbers(arrNumbers))) + " Task №3");

            System.out.println("Numbers with more avg length: " + Arrays.toString(avgLengthArray.getAmountNumbersWithMoreAvgLengthThanLengthAllNumbers(arrNumbers)) + " and their length:" + Arrays.toString(avgLengthArray.getLengthArrayOfNumbers(avgLengthArray.getAmountNumbersWithMoreAvgLengthThanLengthAllNumbers(arrNumbers))) + " Task №3");

            System.out.println("First number with less differences is: " + numbers.getNumberWithMinimumVariousNumbers(initialArr) + " Task №4");

            System.out.println("Number with only odd number is: " + numbers.getNumbersWithOnlyOddValues(initialArr) + " and number with half odd and even numbers is: " + numbers.getAmountHalfOddAndHalfEvenValuesInNumber(initialArr) + " Task №5");

            System.out.println("First increase number with strict orders is: " + numbers.getNumberWithStrictIncreaseOrder(initialArr) + " Task №6");

            System.out.println("Firs max difference number is: " + numbers.getMaxDifferenceNumber(initialArr) + " Task №7");

            System.out.println("********** Try again **********");
        }
    }
}
