package com.epam.automation.javathreads_stage2.optionaltask.planes;

import com.epam.automation.javathreads_stage2.optionaltask.Airport;
import com.epam.automation.javathreads_stage2.optionaltask.console.Printer;
import com.epam.automation.javathreads_stage2.optionaltask.resources.RunAway;

import java.util.concurrent.TimeUnit;

public class Plane implements Runnable {
    private int id;
    private Airport airport;

    public Plane(int id, Airport airport) {
        this.id = id;
        this.airport = airport;
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
        new Printer().printPlaneMoveTowardsRunAway();

        RunAway runAway = airport.getResource(this);

        flyUp(runAway);

        airport.releaseResource(this, runAway);
    }

    public void flyUp(RunAway runAway) {
        try {
            new Printer().printPlaneFlyUp(toString(), runAway);

            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}