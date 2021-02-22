package com.epam.automation.JavaFundamental.optionaltask1;

public class AvgLengthArray {
    String[] getAmountNumbersWithLessAvgLengthThanLengthAllNumbers(String[] numbers) {
        int avgLength = 0;
        int sizeArray = 0;

        for (int i = 0; i < numbers.length; i++) {
            avgLength += numbers[i].length();
        }

        ArraySorter sort = new ArraySorter();

        numbers = sort.getSortedNumbers(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length() <= avgLength / numbers.length) {
                sizeArray++;
            }
        }

        String[] numbersWithLessAvgLengthThanLengthAllNumbers = new String[sizeArray];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length() <= avgLength / numbers.length) {
                numbersWithLessAvgLengthThanLengthAllNumbers[i] = numbers[i];
            }
        }

        return numbersWithLessAvgLengthThanLengthAllNumbers;
    }

    String[] getAmountNumbersWithMoreAvgLengthThanLengthAllNumbers(String[] numbers) {
        int avgLength = 0;
        int countNumbersMore = 0;

        for (int i = 0; i < numbers.length; i++) {
            avgLength += numbers[i].length();
        }

        ArraySorter sort = new ArraySorter();

        numbers = sort.getSortedNumbers(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length() > avgLength / numbers.length) {
                countNumbersMore++;
            }
        }

        String[] numbersWithMoreAvgLengthThanLengthAllNumbers = new String[countNumbersMore];

        int size = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length() > avgLength / numbers.length && size < countNumbersMore) {
                numbersWithMoreAvgLengthThanLengthAllNumbers[size] = numbers[i];

                ++size;
            }
        }

        return numbersWithMoreAvgLengthThanLengthAllNumbers;
    }

    String[] getLengthArrayOfNumbers(String[] numbers) {
        String[] lengthArray = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            lengthArray[i] = String.valueOf(numbers[i].length());
        }

        return lengthArray;
    }
}
