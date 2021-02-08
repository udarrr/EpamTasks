package com.epam.automation.JavaCleanCode;

import com.epam.automation.JavaCleanCode.Enum.ClassificationSecurityLevel;
import com.epam.automation.JavaCleanCode.Enum.MilitaryType;
import com.epam.automation.JavaCleanCode.Enum.PassengerModel;
import com.epam.automation.JavaCleanCode.Planes.ExperimentalPlane;
import com.epam.automation.JavaCleanCode.Planes.MilitaryPlane;
import com.epam.automation.JavaCleanCode.Planes.PassengerPlane;
import com.epam.automation.JavaCleanCode.Planes.Plane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;

public class AirportTest {

    Airport airport = null;
    List<Plane> planes = null;

    @BeforeEach
    public void setUp() {

        planes = PlaneCreator.createListPlanes();
        airport = new Airport(planes);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {

        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();

        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {

            Assert.assertSame(militaryPlane.getMilitaryType(), MilitaryType.TRANSPORT);
        }
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {

        PassengerPlane similarPlaneWithMaxPassengersCapacity = new PassengerPlane(
                PassengerModel.BOEING_747.getModel(),
                PassengerModel.BOEING_747.getMaxSpeed(),
                PassengerModel.BOEING_747.getMaxFlightDistance(),
                PassengerModel.BOEING_747.getMaxLoadCapacity(),
                PassengerModel.BOEING_747.getMaxPassengerCapacity());

        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, similarPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testGetPlanesSortedByMaxLoadCapacity() {

        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();

        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {

            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            Assert.assertTrue(currentPlane.getMaxLoadCapacity() <= nextPlane.getMaxLoadCapacity());
        }
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {

        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();

        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {

            Assert.assertTrue((militaryPlane.getMilitaryType() == MilitaryType.BOMBER));
        }
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {

        List<ExperimentalPlane> ExperimentalPlanes = airport.getExperimentalPlanes();

        for (ExperimentalPlane experimentalPlane : ExperimentalPlanes) {

            Assert.assertTrue(experimentalPlane.getClassificationLevel() != ClassificationSecurityLevel.UNCLASSIFIED);
        }
    }
}
