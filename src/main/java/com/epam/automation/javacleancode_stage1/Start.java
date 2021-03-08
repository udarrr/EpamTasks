package com.epam.automation.javacleancode_stage1;

import com.epam.automation.javacleancode_stage1.Console.Printer;

public class Start {
    public static void main(String[] args) {
        Airport airport = new Airport(PlaneCreator.createListPlanes());

        Printer printer = new Printer();

        printer.printPlanesSortedByMaxDistance(airport);
        printer.printPlanesSortedByMaxSpeed(airport);
        printer.printPassengerPlaneWithMaxPassengersCapacity(airport);
    }
}
