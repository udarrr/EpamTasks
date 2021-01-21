package com.company;

public class SortOfArrayInt {
        int[][] SortOfNumbers(int[][] numbers)   //Task #1
        {
            int temp;
                for (int i = 0; i < numbers.length; i++)
                {
                    boolean exit = true;
                    while (exit)
                    {
                        int mark = 0;
                    for (int j = 0; j < numbers[i].length - 1; j++)
                    {
                        if (numbers[i][j] > numbers[i][j + 1])
                        {
                            temp = numbers[i][j + 1];
                            numbers[i][j + 1] = numbers[i][j];
                            numbers[i][j] = temp;
                            mark++;
                        }
                    }
                        if (mark == 0)
                        {
                        exit = false;
                        }
                    }
            }
            return  numbers;
        }
}
