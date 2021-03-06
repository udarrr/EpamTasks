package com.epam.automation.javaclasses_stage1;

import com.epam.automation.javaclasses_stage1.cars.Car;
import com.epam.automation.javaclasses_stage1.console.CommandReader;
import com.epam.automation.javaclasses_stage1.console.Menu;

public class Start {
    public static void main(String[] args) {
        Car[] cars = new CarCreator().createCars(new CommandReader().getCarsQuantity());
        new Menu().showMenu(cars);
    }
}

