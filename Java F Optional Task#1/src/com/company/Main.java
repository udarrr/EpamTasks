package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int n = 0;
        int i = 0;
        boolean exit = true;
        String[] num = new String[0];

        Scanner sc = new Scanner(System.in);
        System.out.println("Set n numbers, only int ");
        while (exit)
        try
        {
            String setline = sc.nextLine();
            n = Integer.parseInt(setline);
            exit = false;
            num = new String[n];
            System.out.println("Enter " + n + " numbers");
        } catch (Exception e) {
            System.out.println("Only int number");
            }
        
        while (i < n) {
              try {
                String line = sc.nextLine();
                Long.parseLong(line);
                num[i] = line;
                i++;
            } catch (Exception e) {
                  System.out.println("Only numbers,please try again");
            }
        }

        SortOfArray res = new SortOfArray();
        AvgLengthArray avgres = new AvgLengthArray();
        DifferenceNumberOfArray diffres = new DifferenceNumberOfArray();

        System.out.println("Less is: "+ LowerBiggerNumber(num)[0] + " and length is: " +LowerBiggerNumber(num)[0].length()
               + " Big is: " +LowerBiggerNumber(num)[1] + " and length is : " + LowerBiggerNumber(num)[1].length() +" Task №1");
        System.out.println("Sorted array of numbers increase: " + Arrays.toString(res.SortOfNumbers(num)) +" Task №2");
        System.out.println("Sorted array of numbers decrease: " + Arrays.toString(res.SortOfNumbersReverse(num)) +" Task №3");
        System.out.println("Numbers with less avg length: " + Arrays.toString(avgres.AvgHalfOfLengthLess(num) )
               +" and their length:" + Arrays.toString(avgres.LengthOfArrayNumbers(avgres.AvgHalfOfLengthLess(num))) +" Task №4");
        System.out.println("Numbers with more avg length: " + Arrays.toString(avgres.AvgHalfOfLengthMore(num))
                +" and their length:" + Arrays.toString(avgres.LengthOfArrayNumbers(avgres.AvgHalfOfLengthMore(num)))+" Task №5");
        System.out.println("First number with less differences is: " + diffres.DifferenceNumber(num) +" Task №6");
        System.out.println("Increase number with strict orders is: " + diffres.IncreaseNumberOrder(num) +" Task №8");
        System.out.println("Max difference number is: " + diffres.MaxDifferenceNumber(num) +" Task №9");
    }

    public static String[] LowerBiggerNumber(String[] numbers)
    {
        String[] result = new String[2];
        result[0] = numbers[0];
        result[1] = numbers[0];
        for(int i = 0; i < numbers.length;i++)
        {
            if(result[0].length() > numbers[i].length()) {
                result[0] = numbers[i];
            }
            if(result[1].length() < numbers[i].length()) {
                result[1] = numbers[i];
            }
        }
        return result;
    }
}
