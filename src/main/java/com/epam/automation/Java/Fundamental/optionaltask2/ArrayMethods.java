package com.epam.automation.Java.Fundamental.optionaltask2;

import java.util.Arrays;

public class ArrayMethods {

    int[] SearchSequences(int[][] numbers) {
        int[] result = new int[0];
        int countOfLength = 0;
        int jIndexStart = 0;
        int jIndexEnd = 0;
        int tempResJ1 =0;
        int tempResJ2=0;
        int count = 0;

        boolean markNumIs = false;

        for(int i = 0; i < numbers.length; ++i)
        {
            int countOfNum = 0;
            boolean mark = false;

            for(int j = 0; j < numbers[i].length - 1; j++)
            {
                markNumIs =false;

                if (numbers[i][j]>0 && ((numbers[i][j+1] - numbers[i][j]) == 1) && countOfNum == 0
                        || numbers[i][j]<0 && ((numbers[i][j+1] - numbers[i][j]) == -1) && countOfNum == 0)
                {
                    jIndexStart = j;
                    countOfNum++;
                    markNumIs = true;


                } else if (numbers[i][j]>0 && ((numbers[i][j+1] - numbers[i][j]) == 1)
                        || numbers[i][j]<0 && ((numbers[i][j+1] - numbers[i][j]) == -1))
                {
                    countOfNum++;
                    markNumIs = true;
                }

                if (countOfNum > countOfLength)
                {
                    jIndexEnd = j+1;
                    countOfLength = countOfNum;
                }
                if ((jIndexStart !=0 && jIndexEnd !=0) && !markNumIs && count < countOfNum)
                {
                    tempResJ1 = jIndexStart;
                    tempResJ2 = jIndexEnd;
                    count++;
                    jIndexStart =0;
                    jIndexEnd=0;
                    mark = true;
                }
                if (!markNumIs)
                {
                    countOfNum =0;
                    countOfLength =0;
                }
            }
            if(mark)
            {
                result = Arrays.copyOfRange(numbers[i], tempResJ1, tempResJ2 + 1);
            }
        }
        return result;
    }
}
