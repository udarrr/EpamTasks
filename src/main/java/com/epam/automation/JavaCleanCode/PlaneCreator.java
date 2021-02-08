package com.epam.automation.JavaCleanCode;

import com.epam.automation.JavaCleanCode.Enum.ExperimentalModel;
import com.epam.automation.JavaCleanCode.Enum.MilitaryModel;
import com.epam.automation.JavaCleanCode.Enum.PassengerModel;
import com.epam.automation.JavaCleanCode.Planes.ExperimentalPlane;
import com.epam.automation.JavaCleanCode.Planes.MilitaryPlane;
import com.epam.automation.JavaCleanCode.Planes.PassengerPlane;
import com.epam.automation.JavaCleanCode.Planes.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneCreator {

    public static List<Plane> createListPlanes() {

        List<Plane> planes = new ArrayList<>();

        for (int i = 0; i < PassengerModel.values().length; i++) {

            planes.add(new PassengerPlane(PassengerModel.values()[i].getModel(), PassengerModel.values()[i].getMaxSpeed(), PassengerModel.values()[i].getMaxFlightDistance(),
                    PassengerModel.values()[i].getMaxLoadCapacity(), PassengerModel.values()[i].getMaxPassengerCapacity()));
        }

        for (int i = 0; i < MilitaryModel.values().length; i++) {

            planes.add(new MilitaryPlane(MilitaryModel.values()[i].getModel(), MilitaryModel.values()[i].getMaxSpeed(), MilitaryModel.values()[i].getMaxFlightDistance(),
                    MilitaryModel.values()[i].getMaxLoadCapacity(), MilitaryModel.values()[i].getType()));
        }

        for (int i = 0; i < ExperimentalModel.values().length; i++) {

            planes.add(new ExperimentalPlane(ExperimentalModel.values()[i].getModel(), ExperimentalModel.values()[i].getMaxSpeed(), ExperimentalModel.values()[i].getMaxFlightDistance(),
                    ExperimentalModel.values()[i].getMaxLoadCapacity(), ExperimentalModel.values()[i].getType(), ExperimentalModel.values()[i].getSecurityLevel()));
        }

        return planes;
    }
}
