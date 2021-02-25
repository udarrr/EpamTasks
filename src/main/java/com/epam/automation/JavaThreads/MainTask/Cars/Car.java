package com.epam.automation.JavaThreads.MainTask.Cars;

import com.epam.automation.JavaThreads.MainTask.Cars.Resources.Resource;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private final int id;
    private final String registrationNumber;
    private final int timeParking;
    private final Semaphore semaphore;
    private boolean isWaited;

    public void startTimer() {
        Timer tm = new Timer();

        TimerTask timer = new TimerTask() {
            @Override
            public void run() {
                if (!isWaited) {
                    tm.cancel();
                    interrupt();
                } else {
                    tm.cancel();
                }
            }
        };

        tm.schedule(timer, 10000);
    }

    public Car(int id, String registrationNumber, int timeParking, Semaphore semaphore) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.timeParking = timeParking;
        this.semaphore = semaphore;
    }

    public void run() {
        System.out.println("Car " + id + " before parking");
        startTimer();

        try {
            semaphore.acquire();
            int placeOnParking = -1;

            if (!isInterrupted()) {
                isWaited = true;
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
            }

            TimeUnit.MILLISECONDS.sleep(timeParking * 1000L);

            if (!isInterrupted()) {
                synchronized (Resource.AVAILABLE_PARKING) {
                    semaphore.release();
                    sleep(100);
                    System.out.println("Car " + id + " go out from parking " + placeOnParking);
                    Resource.AVAILABLE_PARKING[placeOnParking] = false;
                }
            } else {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            System.out.println("Car " + id + " go away");
        }
    }
}
