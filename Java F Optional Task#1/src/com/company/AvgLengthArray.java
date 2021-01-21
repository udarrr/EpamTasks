package com.company;

public class AvgLengthArray {

        String[] AvgHalfOfLengthLess(String[] numbers) {  //Task #3
        int avgLength = 0;
        int countNumbersLess =0;

        for(int i = 0; i < numbers.length;i++)
        {
            avgLength+=numbers[i].length();
        }
        SortOfArrayNumbers avgRes = new SortOfArrayNumbers();
        numbers = avgRes.SortOfNumbers(numbers);

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

    String[] AvgHalfOfLengthMore(String[] numbers) {
        int avgLength = 0;
        int countNumbersMore =0;

        for(int i = 0; i < numbers.length;i++)
        {
            avgLength+=numbers[i].length();
        }
        SortOfArrayNumbers avgRes = new SortOfArrayNumbers();
        numbers = avgRes.SortOfNumbers(numbers);

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

    String[] LengthOfArrayNumbers(String[] numbers) {

        String[] lengthArr = new String[numbers.length];

        for(int i = 0; i < numbers.length;i++)
        {
            lengthArr[i] =String.valueOf(numbers[i].length());
        }
        return  lengthArr;
    }
}
