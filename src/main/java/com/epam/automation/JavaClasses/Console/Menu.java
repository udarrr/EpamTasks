package com.epam.automation.JavaClasses.Console;

import com.epam.automation.JavaClasses.Cars.Car;

import java.io.IOException;

public class Menu {
    public void showMenu(Car[] cars) {
        Printer printer = new Printer();
        printer.printCarData(cars);

        while (true) {
            printer.printDescriptionOfCommands();

            try {
                Car[] filteredCars = new CommandParser().filter(cars, new CommandReader().readConsoleCommands());

                printer.printCarData(filteredCars);
            } catch (ArrayIndexOutOfBoundsException | IOException e) {
                System.out.println("Command isn't recognised, please try again");
            }
        }
    }
}
