package com.epam.automation.javacleancode_stage1.console;

import com.epam.automation.javacleancode_stage1.Airport;
import com.epam.automation.javacleancode_stage1.planes.MilitaryPlane;
import com.epam.automation.javacleancode_stage1.planes.PassengerPlane;

public class Printer {
    public void printPlanesSortedByMaxDistance(Airport airport) {
        System.out.println("Military planes sorted by max distance: ");

        for (MilitaryPlane militaryPlanesSortMaxDistance : airport.sortByMaxDistance().getMilitaryPlanes()) {
            System.out.println(militaryPlanesSortMaxDistance);
        }
        System.out.println();
    }

    public void printPlanesSortedByMaxSpeed(Airport airport) {
        System.out.println("Passenger planes sorted by max speed: ");

        Airport passengerAirport = new Airport(airport.getPassengerPlane());
        for (PassengerPlane passengerPlanesWithMaxSpeed : passengerAirport.sortByMaxSpeed().getPassengerPlane()) {
            System.out.println(passengerPlanesWithMaxSpeed);
        }
        System.out.println();
    }

    public void printPassengerPlaneWithMaxPassengersCapacity(Airport airport) {
        Airport passengerAirport = new Airport(airport.getPassengerPlane());

        System.out.println("Planes with max passenger capacity: ");
        System.out.println(passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
        System.out.println();
    }
}

