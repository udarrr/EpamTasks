package com.company;

public class DifferenceNumberOfArray {
   String DifferenceNumber(String[] numbers) {

        String result = null;
        int lengthDiff =10;
        SortOfArray sort = new SortOfArray();


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


    String IncreaseNumberOrder(String[] numbers) {

        String result = "Here no number";
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
                lengthNumber = countNum;
                k=0;
            }
        }
        return  result;
    }

    String MaxDifferenceNumber(String[] numbers) {

        String result = "Here no number";
        int lengthNumber =0;
        boolean fail;

        for(int i = 0; i < numbers.length;i++)
        {
            int countDiffNum = 0;
            char[] arrayNum = numbers[i].toCharArray();
            SortOfArray sort = new SortOfArray();
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
