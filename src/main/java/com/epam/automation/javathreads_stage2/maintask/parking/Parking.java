package com.epam.automation.javathreads_stage2.maintask.parking;

import com.epam.automation.javathreads_stage2.maintask.parking.cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Parking {
    int numberParkingPlaces;
    boolean[] availablePlaces;
    List<Car> cars = new ArrayList<>();

    public Parking(int numberParkingPlaces) {
        this.numberParkingPlaces = numberParkingPlaces;
    }

    public int getNumberParkingPlaces() {
        return numberParkingPlaces;
    }

    public void setNumberParkingPlaces(int numberParkingPlaces) {
        this.numberParkingPlaces = numberParkingPlaces;
    }

    public boolean[] getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(boolean[] availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public void start() {
        availablePlaces = new boolean[numberParkingPlaces];

        Random random = new Random();

        Semaphore semaphore = new Semaphore(numberParkingPlaces);

        for (int i = 0; i < 10; i++) {
            new Car(i, random.nextInt(5), semaphore, availablePlaces).start();
        }
    }
}
