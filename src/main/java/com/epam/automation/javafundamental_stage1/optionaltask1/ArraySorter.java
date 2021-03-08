package com.epam.automation.javafundamental_stage1.optionaltask1;

public class ArraySorter {
    String[] getSortedNumbers(String[] numbers) {
        String nextValueSaving;

        boolean exit = true;

        while (exit) {
            int triggerPoint = 0;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i].length() > numbers[i + 1].length()) {
                    nextValueSaving = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = nextValueSaving;
                    triggerPoint++;
                }
            }

            if (triggerPoint == 0) {
                exit = false;
            }
        }

        return numbers;
    }

    String[] sortOfNumbersReverse(String[] numbers) {
        String nextValueSaving;

        boolean exit = true;

        while (exit) {
            int triggerPoint = 0;

            for (int i = numbers.length - 1; i > 0; i--) {
                if (numbers[i].length() > numbers[i - 1].length()) {
                    nextValueSaving = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = nextValueSaving;
                    triggerPoint++;
                }
            }

            if (triggerPoint == 0) {
                exit = false;
            }
        }

        return numbers;
    }

    char[] sortOfNumbersChar(char[] numbers) {
        char nextValueSaving;

        boolean exit = true;

        while (exit) {
            int triggerPoint = 0;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    nextValueSaving = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = nextValueSaving;
                    triggerPoint++;

                }
            }

            if (triggerPoint == 0) {
                exit = false;
            }
        }

        return numbers;
    }
}
