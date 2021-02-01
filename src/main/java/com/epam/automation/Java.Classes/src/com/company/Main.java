package com.epam.automation.Java.Classes.src.com.company;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        ConsoleCommandReader commandsReader = new ConsoleCommandReader();
        Car[] cars = new CarCreator().createCars(commandsReader.getCarsQuantity());

        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.printCarData(cars);

        while(true)
        {
            consolePrinter.printDescriptionOfCommands();

            ConsoleCommandParse consoleCommandParse = new ConsoleCommandParse();

            try
            {
                Car[] carsAfterCommands = consoleCommandParse.getCarsAfterConsoleCommands(cars, commandsReader.readConsoleCommands());

                consolePrinter.printCarData(carsAfterCommands);
            }
            catch (ArrayIndexOutOfBoundsException | IOException e)
            {
                System.out.println("Command isn't recognised, please try again");
            }
        }
    }
}

