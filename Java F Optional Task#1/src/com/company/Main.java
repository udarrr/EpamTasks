package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int n;
        int i = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Set n numbers, only int ");
        String setline = sc.nextLine();
        n = Integer.parseInt(setline);
        String[] num = new String[n];
        System.out.println("Enter "+n+" numbers" );

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
       System.out.println("Less is: "+ LessMoreNumber(num)[0] + " and length is: " +LessMoreNumber(num)[0].length()
               + " Big is: " +LessMoreNumber(num)[1] + " and length is : " + LessMoreNumber(num)[1].length());
       System.out.println("Sorted array of numbers increase: " + Arrays.toString(SortofNumbers(num)));
       System.out.println("Sorted array of numbers decrease: " + Arrays.toString(SortOfNumbersReverse(num)));
       System.out.println("Numbers with less avg length: " + Arrays.toString(AvgHalfOfLengthLess(num))
               +" and their length:" + Arrays.toString(LengthOfArrayNumbers(AvgHalfOfLengthLess(num))));
        System.out.println("Numbers with more avg length: " + Arrays.toString(AvgHalfOfLengthMore(num))
                +" and their length:" + Arrays.toString(LengthOfArrayNumbers(AvgHalfOfLengthMore(num))));

       System.out.println("First number with less differences is: " + DifferenceNumber(num));
    }

    public static String[] LessMoreNumber(String[] numbers)
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

    public static String[] SortofNumbers(String[] numbers)
    {
        String temp;
        boolean exit = true;
        while (exit){
            int mark=0;
            for(int i =0; i< numbers.length-1;i++){
                if(numbers[i].length() > numbers[i+1].length()){
                    temp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = temp;
                    mark++;
                }
            }
            if (mark == 0){
                exit = false;
            }
        }
        return  numbers;
    }

    public static String[] SortOfNumbersReverse(String[] numbers)
    {
        String temp;
        boolean exit = true;
        while (exit){
            int mark=0;
            for(int i=numbers.length-1; i > 0;i--){
                if(numbers[i].length() > numbers[i-1].length())
                {
                    temp = numbers[i-1];
                    numbers[i-1] = numbers[i];
                    numbers[i] = temp;
                    mark++;
                }
            }
            if (mark == 0){
                exit = false;
            }
        }
        return  numbers;
    }

    public static String[] AvgHalfOfLengthLess(String[] numbers) {
        int avgLength = 0;
        int countNumbersLess =0;

        for(int i = 0; i < numbers.length;i++)
        {
            avgLength+=numbers[i].length();
        }
        numbers = SortofNumbers(numbers);

        for(int i = 0; i < numbers.length;i++)
        {
            if(numbers[i].length() <= avgLength/numbers.length)
            {
                countNumbersLess++;
            }
        }
        String[] lessHalfResult = new String[countNumbersLess];

        for(int i = 0; i < numbers.length;i++) {
            if (numbers[i].length() <= avgLength / numbers.length)
            {
                lessHalfResult[i] = numbers[i];
            }
        }
        return  lessHalfResult;
    }

    public static String[] AvgHalfOfLengthMore(String[] numbers) {
        int avgLength = 0;
        int countNumbersMore =0;

        for(int i = 0; i < numbers.length;i++)
        {
            avgLength+=numbers[i].length();
        }
        numbers = SortofNumbers(numbers);

        for(int i = 0; i < numbers.length;i++)
        {
            if(numbers[i].length() > avgLength/numbers.length)
            {
                countNumbersMore++;
            }
        }
        String[] MoreHalfResult = new String[countNumbersMore];
        int count = 0; //чтобы не превысить размерность масива MoreHalfResult = countNumbersMore

        for(int i = 0; i < numbers.length;i++) {
            if (numbers[i].length() > avgLength / numbers.length && count < countNumbersMore)
            {
                MoreHalfResult[count] = numbers[i];
                ++count;
            }
        }
        return  MoreHalfResult;
    }

    public static String[] LengthOfArrayNumbers(String[] numbers) {

        String[] lengthArr = new String[numbers.length];

        for(int i = 0; i < numbers.length;i++)
        {
          lengthArr[i] =String.valueOf(numbers[i].length());
        }
        return  lengthArr;
    }

    public static String DifferenceNumber(String[] numbers) {

        String result = null;
        int k = 0;
        int maxLengthNumber =LessMoreNumber(numbers)[0].length();

        for(int i = 0; i < numbers.length;i++)
        {
            int countDiffNum = 0;
            char[] arrayNum = numbers[i].toCharArray();
             for(int j = 0; j < arrayNum.length;j++)
             {
                 if(arrayNum[k] != arrayNum[j])
                 {
                     countDiffNum++;
                     k=j; //чтобы индекс цифры стал на место посторяющейся цифры, т.е проходил по масиву char и если есть похожая цифра,
                          //стал на ее индекс и сравнился с последующими цифрами.
                 }
             }
             if(countDiffNum < maxLengthNumber)
             {
                 result = numbers[i];
                 maxLengthNumber = countDiffNum;
             }
        }
        return  result;
    }
}
