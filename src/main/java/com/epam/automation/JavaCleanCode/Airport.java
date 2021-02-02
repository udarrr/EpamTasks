package com.epam.automation.JavaCleanCode;

import com.epam.automation.JavaCleanCode.Enum.MilitaryType;
import com.epam.automation.JavaCleanCode.Planes.ExperimentalPlane;
import com.epam.automation.JavaCleanCode.Planes.MilitaryPlane;
import com.epam.automation.JavaCleanCode.Planes.PassengerPlane;
import com.epam.automation.JavaCleanCode.Planes.Plane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Airport
{
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes)
    {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlane()
    {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();

        for (Plane plane : planes)
        {
            if (plane instanceof PassengerPlane)
            {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }

        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes()
    {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();

        for (Plane plane : planes)
        {
            if (plane instanceof MilitaryPlane)
            {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }

        return militaryPlanes;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes()
    {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();

        for (int i = 0; i < militaryPlanes.size(); i++)
        {
            MilitaryPlane plane = militaryPlanes.get(i);

            if (plane.getMilitaryType() == MilitaryType.TRANSPORT)
            {
                transportMilitaryPlanes.add(plane);
            }
        }

        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes()
    {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();

        for (int i = 0; i < militaryPlanes.size(); i++)
        {
            MilitaryPlane plane = militaryPlanes.get(i);

            if (plane.getMilitaryType() == MilitaryType.BOMBER)
            {
                bomberMilitaryPlanes.add(plane);
            }
        }

        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes()
    {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();

        for (Plane plane : planes)
        {
            if (plane instanceof ExperimentalPlane)
            {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }

        return experimentalPlanes;
    }

    public Airport sortByMaxDistance()
    {
        planes.sort((Comparator<Plane>) (o1, o2) -> o1.getMaxFlightDistance() - o2.getMaxFlightDistance());

        return this;
    }

    public Airport sortByMaxSpeed()
    {
        planes.sort((Comparator<Plane>) (o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());

        return this;
    }

    public Airport sortByMaxLoadCapacity()
    {
        planes.sort((Comparator<Plane>) (o1, o2) -> o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity());

        return this;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity()
    {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);

        for (int i = 0; i < passengerPlanes.size(); i++)
        {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity())
            {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }

        return planeWithMaxCapacity;
    }

    public List<? extends Plane> getPlanes()
    {
        return planes;
    }

    @Override
    public String toString()
    {
        return "Airport{" + "Planes=" + planes.toString() + '}';
    }
}
