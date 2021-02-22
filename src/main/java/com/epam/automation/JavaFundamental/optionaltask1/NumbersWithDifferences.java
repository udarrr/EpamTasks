package com.epam.automation.JavaFundamental.optionaltask1;

public class NumbersWithDifferences {
    String[] getLowerOrBiggerNumber(String[] numbers) {

        String[] result = new String[2];

        String biggerNumber = result[0] = numbers[0];
        String lowerNumber = result[1] = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (biggerNumber.length() > numbers[i].length()) {
                biggerNumber = numbers[i];
            }

            if (lowerNumber.length() < numbers[i].length()) {
                lowerNumber = numbers[i];
            }
        }

        return result;
    }

    String getNumberWithMinimumVariousNumbers(String[] numbers) {
        String possibleResult = "NO RESULT";

        int amountVariousValues = 10;

        for (int i = 0; i < numbers.length; i++) {
            int amountValuesInSequences = 0;

            char[] numberToCharArray = numbers[i].toCharArray();

            new ArraySorter().sortOfNumbersChar(numberToCharArray);

            for (int j = 0; j < numberToCharArray.length - 1; j++) {
                if (numberToCharArray[0] != numberToCharArray[j + 1]) {
                    amountValuesInSequences++;
                }
            }

            if (amountValuesInSequences < amountVariousValues) {
                possibleResult = numbers[i];
                amountVariousValues = amountValuesInSequences;
            }
        }

        return possibleResult;
    }

    int getNumbersWithOnlyOddValues(String[] numbers) {
        int numbersWithOddValues = 0;
        int amountNumberWithOddValues = 0;

        for (int i = 0; i < numbers.length; i++) {
            char[] numberToCharArray = numbers[i].toCharArray();

            new ArraySorter().sortOfNumbersChar(numberToCharArray);

            for (int j = 0; j < numberToCharArray.length - 1; j++) {
                if (numberToCharArray[j] % 2 == 0) {
                    amountNumberWithOddValues++;
                }
            }

            if (amountNumberWithOddValues == numberToCharArray.length - 1) {
                numbersWithOddValues++;
            }
            amountNumberWithOddValues = 0;

        }
        return numbersWithOddValues;
    }

    int getAmountHalfOddAndHalfEvenValuesInNumber(String[] numbers) {

        int amount = 0;
        int countOddFirstHalf = 0;
        int countEvenFirstHalf = 0;
        int countOddSecondHalf = 0;
        int countEvenSecondHalf = 0;

        for (int i = 0; i < numbers.length; i++) {
            char[] numberToCharArray = numbers[i].toCharArray();

            for (int j = 0; j < numberToCharArray.length; j++) {
                if (numberToCharArray[j] % 2 == 1 && j < numberToCharArray.length / 2) {
                    countOddFirstHalf++;
                }

                if (numberToCharArray[j] % 2 == 0 && j < numberToCharArray.length / 2) {
                    countEvenFirstHalf++;
                }

                if ((numberToCharArray[j] % 2 == 1) && (j >= numberToCharArray.length / 2) && (countEvenFirstHalf != 0)) {
                    countOddSecondHalf++;
                }

                if ((numberToCharArray[j] % 2 == 0) && (j >= numberToCharArray.length / 2) && (countOddFirstHalf != 0)) {
                    countEvenSecondHalf++;
                }
            }

            if (((countOddFirstHalf == 0 && countEvenFirstHalf != 0) || (countOddFirstHalf != 0 && countEvenFirstHalf == 0)) &&
                    ((countOddSecondHalf == 0 && countEvenSecondHalf != 0) || (countOddSecondHalf != 0 && countEvenSecondHalf == 0))) {

                amount++;
            }

            countOddFirstHalf = 0;
            countEvenFirstHalf = 0;
            countOddSecondHalf = 0;
            countEvenSecondHalf = 0;
        }

        return amount;
    }

    String getNumberWithStrictIncreaseOrder(String[] numbers) {
        String possibleResult = "NO RESULT";

        int index = 0;
        int lengthNumber = 0;

        boolean fail;

        for (int i = 0; i < numbers.length; i++) {
            int potentialNumber = 0;

            fail = false;

            char[] numberToCharArray = numbers[i].toCharArray();

            for (int j = 0; j < numberToCharArray.length - 1; j++) {
                if ((numberToCharArray[index] < numberToCharArray[j + 1]) && ((numberToCharArray[j + 1] % numberToCharArray[index] == 1) || (numberToCharArray[j + 1] % numberToCharArray[index] == 0))) {
                    potentialNumber++;
                    index = j + 1;
                } else {
                    fail = true;
                    break;
                }
            }

            if (potentialNumber > lengthNumber && (!fail)) {
                possibleResult = numbers[i];

                break;
            }

            index = 0;
        }

        return possibleResult;
    }

    String getMaxDifferenceNumber(String[] numbers) {
        String possibleResult = "NO RESULT";
        int lengthNumber = 0;
        boolean fail;

        for (int i = 0; i < numbers.length; i++) {
            int valueMaxDifferences = 0;
            char[] numberToCharArray = numbers[i].toCharArray();

            new ArraySorter().sortOfNumbersChar(numberToCharArray);

            fail = false;

            for (int j = 0; j < numberToCharArray.length - 1; j++) {
                if (numberToCharArray[j] != numberToCharArray[j + 1]) {
                    valueMaxDifferences++;
                } else {
                    fail = true;

                    break;
                }
            }

            if ((valueMaxDifferences > lengthNumber) && !fail) {
                possibleResult = numbers[i];
                lengthNumber = valueMaxDifferences;
            }
        }

        return possibleResult;
    }
}
