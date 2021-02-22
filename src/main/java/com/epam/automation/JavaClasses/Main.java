package com.epam.automation.JavaClasses;

import com.epam.automation.JavaClasses.Cars.Car;
import com.epam.automation.JavaClasses.Console.CommandReader;
import com.epam.automation.JavaClasses.Console.Menu;

public class Main {

    public static void main(String[] args) {
        Car[] cars = new CarCreator().createCars(new CommandReader().getCarsQuantity());
        new Menu().showMenu(cars);
    }
}

