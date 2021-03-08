package com.epam.automation.javacleancode_stage1;

import com.epam.automation.javacleancode_stage1.enums.ExperimentalModel;
import com.epam.automation.javacleancode_stage1.enums.MilitaryModel;
import com.epam.automation.javacleancode_stage1.enums.PassengerModel;
import com.epam.automation.javacleancode_stage1.planes.ExperimentalPlane;
import com.epam.automation.javacleancode_stage1.planes.MilitaryPlane;
import com.epam.automation.javacleancode_stage1.planes.PassengerPlane;
import com.epam.automation.javacleancode_stage1.planes.Plane;

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
