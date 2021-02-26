package com.epam.automation.JavaThreads.MainTask.Parking.Cars;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private final int id;
    private final int timeParking;
    private final Semaphore semaphore;
    private boolean isWaited;
    boolean[] availablePlaces;

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

    public Car(int id, int timeParking, Semaphore semaphore, boolean[] availablePlaces) {
        this.id = id;
        this.timeParking = timeParking;
        this.semaphore = semaphore;
        this.availablePlaces = availablePlaces;
    }

    public void run() {
        System.out.println("Car " + id + " before parking");
        startTimer();

        try {
            semaphore.acquire();
            int placeOnParking = -1;

            if (!isInterrupted()) {
                isWaited = true;
                synchronized (availablePlaces) {
                    for (int i = 0; i < availablePlaces.length; i++) {
                        if (!availablePlaces[i]) {
                            availablePlaces[i] = true;
                            placeOnParking = i;

                            System.out.println("Car " + id + " parked " + placeOnParking);
                            break;
                        }
                    }
                }
            }

            TimeUnit.MILLISECONDS.sleep(timeParking * 1000L);

            if (!isInterrupted()) {
                synchronized (availablePlaces) {
                    semaphore.release();
                    sleep(100);

                    System.out.println("Car " + id + " go out from parking " + placeOnParking);

                    availablePlaces[placeOnParking] = false;
                }
            } else {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            System.out.println("Car " + id + " go away");
        }
    }
}
