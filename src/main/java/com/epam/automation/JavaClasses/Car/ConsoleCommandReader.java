package com.epam.automation.JavaClasses.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleCommandReader
{
    public int getCarsQuantity()
    {
        int quantityCarsInArray;

        System.out.println("Enter the wish quantity cars from catalog: ");

        while (true)
        {
            try
            {
                Scanner sc = new Scanner(System.in);

                quantityCarsInArray = sc.nextInt();

                return quantityCarsInArray;

            } catch (Exception e)
            {
                System.out.println("Quantity have to be an integer number, please enter quantity again");
            }
        }
    }

    public String[] readConsoleCommands() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] commands = reader.readLine().split("[\\s(^'.$)]");

        return commands;
    }
}
