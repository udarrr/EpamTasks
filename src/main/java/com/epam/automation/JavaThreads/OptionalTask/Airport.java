package com.epam.automation.JavaThreads.OptionalTask;

import com.epam.automation.JavaThreads.OptionalTask.Planes.Plane;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Airport {
    int runaway;
    boolean[] availableLine;
    Semaphore semaphore;
    List<Plane> planes;

    public Airport(int runaway) {
        this.runaway = runaway;
    }

    public void addPlane(Plane p) {
        planes.add(p);
    }

    public void start() {
        semaphore = new Semaphore(runaway);
        availableLine = new boolean[runaway];
        planes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            addPlane(new Plane(i, semaphore, availableLine));
        }
        planes.forEach(x -> new Thread(x).start());
    }
}
