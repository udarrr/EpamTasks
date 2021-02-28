package com.epam.automation.JavaThreads.OptionalTask.Resources;

import java.util.concurrent.Semaphore;

public class PlanningResources {
    private int runaway;
    Semaphore semaphore;

    public PlanningResources(int runaway) {
        semaphore = new Semaphore(runaway, true);
        this.runaway = runaway;
    }

    public int getAvailableRunaway() {
        return runaway;
    }

    public void setAvailableRunaway(int runaway) {
        this.runaway = runaway;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }
}
