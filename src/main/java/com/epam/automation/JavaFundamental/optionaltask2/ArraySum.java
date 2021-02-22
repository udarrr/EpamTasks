package com.epam.automation.JavaFundamental.optionaltask2;

public class ArraySum {
    public static int[] sumLinesArray(int[][] array) {
        int[] result = new int[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[j] = result[j] + array[i][j];
            }
        }

        return result;
    }
}
