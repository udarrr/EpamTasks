package com.epam.automation.Java.Classes.src.com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        boolean exit = true;
        int quantity = 0;

        System.out.println("Enter quantity cars from catalog: ");

        while (exit)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                quantity = sc.nextInt();
                exit = false;
            } catch (Exception e)
            {
                System.out.println("Quantity is a integer number, please enter quantity again");
                exit = true;
            }
        }
        Car[] cars = new CarCreator().createCarData(quantity);
        CommandsReader commandsReader = new CommandsReader();
        commandsReader.start(cars);
    }
}

