package com.epam.automation.JavaThreads.OptionalTask.Planes;

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class Plane implements Runnable {
    private int id;
    private Semaphore orderDeparture;
    private boolean[] availableLine;
    private int occupiedLine;

    public Plane(int id, Semaphore orderDeparture, boolean[] availableLine) {
        this.id = id;
        this.orderDeparture = orderDeparture;
        this.availableLine = availableLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                '}';
    }

    @Override
    public void run() {
        try {
            Timer tm = new Timer();

            System.out.println(toString() + " plane begins to move towards the runways");

            orderDeparture.acquire();

            chooseRunaway(tm);

            System.out.println(toString() + " is flying up from " + occupiedLine);

            Thread.sleep(2500);

            freeRunaway(tm);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chooseRunaway(Timer tm) throws InterruptedException {
        synchronized (availableLine) {
            for (int i = 0; i < availableLine.length; i++) {
                if (!availableLine[i]) {
                    availableLine[i] = true;
                    occupiedLine = i;

                    startTimer(tm);

                    System.out.println(toString() + " enter on runway " + occupiedLine + " " + Instant.now());

                    Thread.sleep(500);
                    break;
                }
            }
        }
    }

    public void freeRunaway(Timer tm) throws InterruptedException {
        synchronized (availableLine) {
            orderDeparture.release();

            System.out.println(toString() + " freed runaway " + occupiedLine + " " + Instant.now());

            tm.cancel();

            availableLine[occupiedLine] = false;
        }
    }

    public void startTimer(Timer tm) {
        TimerTask timer = new TimerTask() {
            @Override
            public void run() {
                System.err.println(Plane.this.toString() + " take more than 3 minute");
            }
        };
        tm.schedule(timer, 4000);
    }

    public void endTimer(Timer timer) {
        timer.cancel();
    }
}
