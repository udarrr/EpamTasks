package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        while(true) {
            CreateArrayN arr = new CreateArrayN();
            String[] arrNumbers = arr.createAndFillArr();
            String[] initialArr = Arrays.copyOf(arrNumbers, arrNumbers.length);

            SortOfArrayNumbers res = new SortOfArrayNumbers();
            AvgLengthArray avgres = new AvgLengthArray();
            DifferenceNumberOfArray diff = new DifferenceNumberOfArray();

            System.out.println("Less is: " + diff.LowerBiggerNumber(arrNumbers)[0] + " and length is: " + diff.LowerBiggerNumber(arrNumbers)[0].length()
                    + " Big is: " + diff.LowerBiggerNumber(arrNumbers)[1] + " and length is : " + diff.LowerBiggerNumber(arrNumbers)[1].length() + " Task №1");
            System.out.println("Sorted array of numbers increase: " + Arrays.toString(res.SortOfNumbers(arrNumbers)) + " Task №2");
            System.out.println("Sorted array of numbers decrease: " + Arrays.toString(res.SortOfNumbersReverse(arrNumbers)) + " Task №2");
            System.out.println("Numbers with less avg length: " + Arrays.toString(avgres.AvgHalfOfLengthLess(arrNumbers))
                    + " and their length:" + Arrays.toString(avgres.LengthOfArrayNumbers(avgres.AvgHalfOfLengthLess(arrNumbers))) + " Task №3");
            System.out.println("Numbers with more avg length: " + Arrays.toString(avgres.AvgHalfOfLengthMore(arrNumbers))
                    + " and their length:" + Arrays.toString(avgres.LengthOfArrayNumbers(avgres.AvgHalfOfLengthMore(arrNumbers))) + " Task №3");
            System.out.println("First number with less differences is: " + diff.DifferenceNumber(initialArr) + " Task №4");
            System.out.println("Number with only odd number is: " + diff.OddNumber(initialArr) + " and number with half odd and even numbers is: "
                    + diff.OddAndEvenHalfNumber(initialArr) + " Task №5");
            System.out.println("First increase number with strict orders is: " + diff.IncreaseNumberOrder(initialArr) + " Task №6");
            System.out.println("Firs max difference number is: " + diff.MaxDifferenceNumber(initialArr) + " Task №7");

            System.out.println("********** Try again **********");
        }
    }
}
