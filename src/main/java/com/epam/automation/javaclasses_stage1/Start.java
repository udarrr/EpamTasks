package com.epam.automation.javaclasses_stage1;

import com.epam.automation.javaclasses_stage1.Cars.Car;
import com.epam.automation.javaclasses_stage1.Console.CommandReader;
import com.epam.automation.javaclasses_stage1.Console.Menu;

public class Start {
    public static void main(String[] args) {
        Car[] cars = new CarCreator().createCars(new CommandReader().getCarsQuantity());
        new Menu().showMenu(cars);
    }
}

