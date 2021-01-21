package com.company;

import java.util.Arrays;

public class ArrayMethods {

    int[] SearchSequences(int[][] numbers) {  //Task #6

        int[] result = new int[0];
        int k = 0;
        int lengthNumber =0;
        boolean fail = false;
        int jIndexStart = 0;
        int jIndexEnd = 0;

        for(int i = 0; i < numbers.length;i++)
        {
            int count = 0;

            for(int j = 0; j < numbers[i].length-1;j++)
            {
                if (numbers[i][j+1] != 0 && numbers[i][k] ==0)
                {
                    jIndexStart = j;
                    k++;
                    fail = false;
                }
                if(((numbers[i][k] < numbers[i][j+1]) && ((numbers[i][j+1] % numbers[i][k]== 1)) && (count == 0)))
                {
                    jIndexStart = j;
                    count++;
                    k++;
                    fail = false;
                }
                else if((numbers[i][k] < numbers[i][j+1]) && ((numbers[i][j+1] % numbers[i][k]== 1)))
                {
                    count++;
                    k++;
                    fail = false;
                }

                if(fail == false)
                {
                    jIndexEnd =j;
                    fail = true;
                }
            }
            if(count > lengthNumber)
            {
                result = Arrays.copyOfRange(numbers[i],jIndexStart,jIndexEnd);
                lengthNumber = result.length;
            }

            k=0;
        }
        return  result;
    }
}
