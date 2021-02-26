package com.epam.automation.JavaCleanCode;

import com.epam.automation.JavaCleanCode.Console.Printer;

public class Start {
    public static void main(String[] args) {
        Airport airport = new Airport(PlaneCreator.createListPlanes());

        Printer printer = new Printer();

        printer.printPlanesSortedByMaxDistance(airport);
        printer.printPlanesSortedByMaxSpeed(airport);
        printer.printPassengerPlaneWithMaxPassengersCapacity(airport);
    }
}
