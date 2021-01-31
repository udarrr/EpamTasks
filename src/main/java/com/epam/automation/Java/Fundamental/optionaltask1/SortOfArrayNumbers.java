package com.epam.automation.Java.Fundamental.optionaltask1;

public class SortOfArrayNumbers {
    String[] SortOfNumbers(String[] numbers)   //Task #2
    {
        String temp;
        boolean exit = true;
        while (exit){
            int mark=0;
            for(int i =0; i< numbers.length-1;i++){
                if(numbers[i].length() > numbers[i+1].length()){
                    temp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = temp;
                    mark++;
                }
            }
            if (mark == 0){
                exit = false;
            }
        }
        return  numbers;
    }

    String[] SortOfNumbersReverse(String[] numbers)
    {
        String temp;
        boolean exit = true;
        while (exit){
            int mark=0;
            for(int i=numbers.length-1; i > 0;i--){
                if(numbers[i].length() > numbers[i-1].length())
                {
                    temp = numbers[i-1];
                    numbers[i-1] = numbers[i];
                    numbers[i] = temp;
                    mark++;
                }
            }
            if (mark == 0){
                exit = false;
            }
        }
        return  numbers;
    }

    char[] SortOfNumbersChar(char[] numbers)
    {
        char temp;
        boolean exit = true;
        while (exit){
            int mark=0;
            for(int i =0; i< numbers.length-1;i++){
                if(numbers[i] > numbers[i+1]){
                    temp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = temp;
                    mark++;
                }
            }
            if (mark == 0){
                exit = false;
            }
        }
        return  numbers;
    }
}
