package com.epam.automation.JavaCleanCode;

import com.epam.automation.JavaCleanCode.Planes.MilitaryPlane;
import com.epam.automation.JavaCleanCode.Planes.PassengerPlane;

public class ConsolePrinter
{
    public static void main(String[] args)
    {
        Airport airport = new Airport(PlaneCreator.createListPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlane());

        System.out.println("Military planes sorted by max distance: ");

        for (MilitaryPlane militaryPlanesSortMaxDistance : airport.sortByMaxDistance().getMilitaryPlanes())
        {
            System.out.println(militaryPlanesSortMaxDistance);
        }
        System.out.println("Passenger planes sorted by max speed: ");

        for (PassengerPlane passengerPlanesWithMaxSpeed : passengerAirport.sortByMaxSpeed().getPassengerPlane())
        {
            System.out.println(passengerPlanesWithMaxSpeed);
        }

        System.out.println("Planes with max passenger capacity: ");
        System.out.println(passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
