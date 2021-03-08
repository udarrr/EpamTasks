package com.epam.automation.javacollections_stage1.OptionalTask;

import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

public class StartPoint7 {

    public static void main(String[] args) throws IOException {
        String line = "(», «)», «[», «]», «{», «}»";

        Stack<Character> stack = new Stack<>();

        char[] lineArray = line.toCharArray();

        boolean isCorrectLine = false;

        int isCircleBracket = 0;
        int isSquareBracket = 0;
        int isFigureBracket = 0;

        for (Character character : lineArray) {
            stack.add(character);
        }

        stack = reverseStack(stack);

        Iterator<Character> iterator = stack.iterator();

        while (iterator.hasNext()) {
            if (stack.peek().equals('(') && isCircleBracket < 1) {
                isCircleBracket++;

                if (checkOpenCircleBrackets(stack)) {
                    isCorrectLine = true;

                } else {
                    isCorrectLine = false;

                    break;
                }

            } else if (stack.peek().equals(')') || stack.peek().equals('(') && isCircleBracket >= 1) {
                isCorrectLine = false;

                break;
            }

            if (stack.peek().equals('[') && isSquareBracket < 1) {
                isSquareBracket++;

                if (checkOpenSquareBrackets(stack)) {
                    isCorrectLine = true;
                } else {
                    isCorrectLine = false;

                    break;
                }

            } else if (stack.peek().equals(']') || stack.peek().equals('[') && isSquareBracket >= 1) {
                isCorrectLine = false;

                break;
            }

            if (stack.peek().equals('{') && isFigureBracket < 1) {
                isFigureBracket++;

                if (checkFigureBrackets(stack)) {
                    isCorrectLine = true;
                } else {
                    isCorrectLine = false;

                    break;
                }

            } else if (stack.peek().equals('}') || stack.peek().equals('{') && isFigureBracket >= 1) {
                isCorrectLine = false;

                break;
            }
            stack.pop();
        }

        if (isCorrectLine) {
            System.out.println("Brackets stand right" + "(" + isCorrectLine + ")");
        } else {
            System.out.println("Brackets don't stand right" + "(" + isCorrectLine + ")");
        }
    }

    static boolean checkOpenCircleBrackets(Stack<Character> check) {

        Iterator<Character> iterator = check.iterator();

        while (iterator.hasNext()) {
            check.pop();

            if (check.peek().equals(')')) {
                return true;

            } else if (check.peek().equals('(')) {
                return false;
            }
        }

        return false;
    }

    static boolean checkOpenSquareBrackets(Stack<Character> check) {
        Iterator<Character> iterator = check.iterator();

        while (iterator.hasNext()) {
            check.pop();

            if (check.peek().equals(']')) {
                return true;
            } else if (check.peek().equals('[')) {
                return false;
            }
        }

        return false;
    }

    static boolean checkFigureBrackets(Stack<Character> check) {
        Iterator<Character> iterator = check.iterator();

        while (iterator.hasNext()) {
            check.pop();

            if (check.peek().equals('}')) {
                return true;

            } else if (check.peek().equals('{')) {
                return false;
            }
        }

        return false;
    }

    static Stack<Character> reverseStack(Stack<Character> stack) {
        Stack<Character> reverseStack = new Stack<>();
        Iterator<Character> iterator = stack.iterator();

        while (iterator.hasNext()) {
            reverseStack.add(stack.peek());
            stack.pop();
        }

        return reverseStack;
    }
}
