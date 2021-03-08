package com.epam.automation.javaclasses_stage1.console;

import com.epam.automation.javaclasses_stage1.cars.Car;

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
