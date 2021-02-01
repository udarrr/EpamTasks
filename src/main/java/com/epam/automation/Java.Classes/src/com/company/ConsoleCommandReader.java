package com.epam.automation.Java.Classes.src.com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleCommandReader
{
    public int getWishQuantityCarsForArray()
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
                System.out.println("Quantity have to be a integer number, please enter quantity again");
            }
        }
    }

    public String[] readConsoleCommands() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String[] commands = reader.readLine().split("[\\s(^'.$)]");

        return commands;
    }

    public Car[] getParametersCars(String firstCondition, String secondCondition, String command, Car[] cars)
    {
        Car[] carParameter = new Car[0];
        ConsoleCommandParse consoleCommandParse = new ConsoleCommandParse();

        switch (firstCondition)
        {
            case "vendor":
                carParameter = consoleCommandParse.getVendor(cars, secondCondition, command);
                break;
            case "model":
                carParameter = consoleCommandParse.getModel(cars, secondCondition, command);
                break;
            case "regId":
                carParameter = consoleCommandParse.getRegistrationNumber(cars, secondCondition, command);
                break;
            case "color":
                carParameter = consoleCommandParse.getColor(cars, secondCondition, command);
                break;
            case "year":
                carParameter = consoleCommandParse.getYear(cars, Integer.parseInt(secondCondition), command);
                break;
            case "price":
                carParameter = consoleCommandParse.getPrice(cars, Double.parseDouble(secondCondition), command);
                break;
            default:
                System.out.println("Parameter isn't recognized");
        }

        return carParameter;
    }
}
