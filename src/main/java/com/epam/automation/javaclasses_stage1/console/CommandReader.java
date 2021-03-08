package com.epam.automation.javaclasses_stage1.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CommandReader {
    public int getCarsQuantity() {
        String inputConsoleValue = "";
        String exit = "exit";

        System.out.println("Enter quantity cars from catalog: ");

        while (!inputConsoleValue.equalsIgnoreCase(exit)) {
            try {
                Scanner sc = new Scanner(System.in);

                inputConsoleValue = sc.nextLine();

                if (inputConsoleValue.equals(exit)) {
                    inputConsoleValue = exit;

                } else {
                    return Integer.parseInt(inputConsoleValue);
                }
            } catch (Exception e) {
                System.out.println("Quantity have to be an integer number, please enter quantity again");
            }
        }

        return 0;
    }

    public String[] readConsoleCommands() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine().split("[\\s(^'.$)]");
    }
}
