package com.epam.automation.JavaFundamental.optionaltask2;

public class ArraySorter
{

    public static int[][] sortOfNumbers(int[][] numbers)
    {

        for (int i = 0; i < numbers.length; ++i)
        {

            while (true)
            {

                int point = 0;

                for (int j = 0; j < numbers[i].length - 1; ++j)
                {

                    if (numbers[i][j] > numbers[i][j + 1])
                    {

                        int temp = numbers[i][j + 1];

                        numbers[i][j + 1] = numbers[i][j];
                        numbers[i][j] = temp;

                        ++point;
                    }
                }

                if (point == 0)
                {

                    break;
                }
            }
        }

        return numbers;
    }
}
