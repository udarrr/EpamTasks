package com.epam.automation.JavaThreads.MainTask.Cars;

import com.epam.automation.JavaThreads.MainTask.Resources.Resource;

import java.nio.file.Path;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    int id;
    String registrationNumber;
    int timeParking;
    Semaphore semaphore;

    public Car(int id, String registrationNumber, int timeParking, Semaphore semaphore) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.timeParking = timeParking;
        this.semaphore = semaphore;
    }

    private synchronized boolean isPlace() {
        for (int i = 0; i < Resource.AVAILABLE_PARKING.length; i++) {
            if (Resource.AVAILABLE_PARKING[i]) {
                return true;
            }
        }
        return false;
    }

    public void run() {
        System.out.println("Car " + id + " before parking");

        try {
            semaphore.acquire();

            int placeOnParking = -1;

            synchronized (Resource.AVAILABLE_PARKING) {
                for (int i = 0; i < Resource.NUMBER_OF_PARKING_PLACES; i++) {
                    if (!Resource.AVAILABLE_PARKING[i]) {
                        Resource.AVAILABLE_PARKING[i] = true;
                        placeOnParking = i;
                        System.out.println("Car " + id + " parked " + placeOnParking);

                        break;
                    }
                }
            }

            TimeUnit.MILLISECONDS.sleep(timeParking * 1000L);

            synchronized (Resource.AVAILABLE_PARKING) {
                semaphore.release();
                sleep(100);
                System.out.println("Car " + id + " go out from parking " + placeOnParking);
                Resource.AVAILABLE_PARKING[placeOnParking] = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
