package com.epam.automation.JavaFundamental.optionaltask1;

public class DifferenceNumber
{
    String[] getLowerOrBiggerNumber(String[] numbers)  //Task #1
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

   String getNumberWithMinimumVariousNumbers(String[] numbers) {  //Task #4

        String result = "NO RESULT";
        int lengthDiff =10;
       ArraySorter sort = new ArraySorter();


        for(int i = 0; i < numbers.length;i++)
        {
            int countDiffNum = 0;
            char[] arrayNum = numbers[i].toCharArray();
            sort.SortOfNumbersChar(arrayNum);

            for(int j = 0; j < arrayNum.length-1;j++)
            {
                if(arrayNum[0] != arrayNum[j+1])
                {
                    countDiffNum++;
                }
            }
            if(countDiffNum < lengthDiff)
            {
                result = numbers[i];
                lengthDiff = countDiffNum;
            }
        }
        return  result;
    }

    int OddNumber(String[] numbers) {  //Task #5
        int result = 0;
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            char[] arrayNum = numbers[i].toCharArray();
            ArraySorter sort = new ArraySorter();
            sort.SortOfNumbersChar(arrayNum);
            for (int j = 0; j < arrayNum.length-1; j++) {
                if(arrayNum[j] % 2 == 0){
                    count++;
                }
            }
            if(count == arrayNum.length-1){
                result++;
            }
            count = 0;
        }
        return result;
    }

    int OddAndEvenHalfNumber(String[] numbers) {
        int result = 0;
        int countOddFirstHalf = 0;
        int countEvenFirstHalf = 0;
        int countOddSecondHalf = 0;
        int countEvenSecondHalf =0;

        for (int i = 0; i < numbers.length; i++) {
            char[] arrayNum = numbers[i].toCharArray();

            for (int j = 0; j < arrayNum.length; j++) {

                if(arrayNum[j] % 2 == 1 && j<arrayNum.length/2){
                    countOddFirstHalf++;
                }
                if (arrayNum[j] % 2 == 0 && j<arrayNum.length/2){
                    countEvenFirstHalf++;
                }
                if((arrayNum[j] % 2 == 1) && (j>=arrayNum.length/2) && (countEvenFirstHalf !=0)){
                    countOddSecondHalf++;
                }
                if ((arrayNum[j] % 2 == 0) && (j>=arrayNum.length/2) && (countOddFirstHalf !=0)){
                    countEvenSecondHalf++;
                }
            }
            if(((countOddFirstHalf ==0 && countEvenFirstHalf !=0) ||
                    (countOddFirstHalf !=0 && countEvenFirstHalf ==0)) &&
                    ((countOddSecondHalf ==0 && countEvenSecondHalf !=0) ||
                            (countOddSecondHalf !=0 && countEvenSecondHalf ==0))){
                result++;
            }
            countOddFirstHalf = 0;
            countEvenFirstHalf = 0;
            countOddSecondHalf = 0;
            countEvenSecondHalf =0;
        }
        return result;
    }

    String IncreaseNumberOrder(String[] numbers) {  //Task #6

        String result = "NO RESULT";
        int k = 0;
        int lengthNumber =0;
        boolean fail;

        for(int i = 0; i < numbers.length;i++)
        {
            int countNum = 0;
            fail =false;
            char[] arrayNum = numbers[i].toCharArray();

            for(int j = 0; j < arrayNum.length-1;j++)
            {
                if((arrayNum[k] < arrayNum[j+1]) && ((arrayNum[j+1] % arrayNum[k]== 1) || (arrayNum[j+1] % arrayNum[k]== 0)))
                {
                    countNum++;
                    k=j+1;
                }
                else
                {
                    fail = true;
                    break;
                }
            }
            if(countNum > lengthNumber && (!fail))
            {
                result = numbers[i];
                break;
            }
            k=0;
        }
        return  result;
    }

    String MaxDifferenceNumber(String[] numbers) {  //Task #7

        String result = "NO RESULT";
        int lengthNumber =0;
        boolean fail;

        for(int i = 0; i < numbers.length;i++)
        {
            int countDiffNum = 0;
            char[] arrayNum = numbers[i].toCharArray();
            ArraySorter sort = new ArraySorter();
            sort.SortOfNumbersChar(arrayNum);
            fail = false;
            for(int j = 0; j < arrayNum.length-1;j++)
            {
                if(arrayNum[j] != arrayNum[j+1])
                {
                    countDiffNum++;
                }
                else {
                    fail = true;
                    break;
                }
            }
            if((countDiffNum > lengthNumber) && !fail)
            {
                result = numbers[i];
                lengthNumber = countDiffNum;
            }
        }
        return  result;
    }
}
