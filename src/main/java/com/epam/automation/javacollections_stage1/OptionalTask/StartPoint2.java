package com.epam.automation.javacollections_stage1.OptionalTask;

import java.util.*;

public class StartPoint2 {

    public static void main(String[] args) {
        int lineWithNumber = 0;
        boolean exit = true;

        System.out.println("Enter below integer number:");

        while (exit) {
            try {
                Scanner sc = new Scanner(System.in);
                lineWithNumber = sc.nextInt();
                exit = false;

            } catch (InputMismatchException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
                System.out.println("Please enter only integer number");
                exit = true;
            }
        }

        char[] charNumberArray = Integer.toString(lineWithNumber).toCharArray();

        Stack<Character> numberInStack = new Stack<>();

        for (int i = 0; i < charNumberArray.length; i++) {
            numberInStack.addElement(charNumberArray[i]);
        }

        Iterator iterator = numberInStack.iterator();

        List<Character> numberAfterReverseChar = new ArrayList<>();

        while (iterator.hasNext()) {
            numberAfterReverseChar.add(numberInStack.peek());
            numberInStack.pop();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Character outToPrinting : numberAfterReverseChar) {
            stringBuilder.append(outToPrinting);
        }

        System.out.println("Number after revers:");
        System.out.println(Integer.parseInt(String.valueOf(stringBuilder)));
    }
}
