package com.epam.automation.JavaClasses.Car;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ConsoleCommandReader commandsReader = new ConsoleCommandReader();

        Car[] cars = new CarCreator().createCars(commandsReader.getCarsQuantity());

        ConsolePrinter consolePrinter = new ConsolePrinter();
        new ConsolePrinter().printCarData(cars);

        while (true) {

            consolePrinter.printDescriptionOfCommands();

            ConsoleCommandParser carsFilter = new ConsoleCommandParser();

            try {
                Car[] filteredCars = carsFilter.filter(cars, commandsReader.readConsoleCommands());

                consolePrinter.printCarData(filteredCars);

            } catch (ArrayIndexOutOfBoundsException | IOException e) {

                System.out.println("Command isn't recognised, please try again");
            }
        }
    }
}

