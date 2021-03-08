package com.epam.automation.javathreads_stage2.OptionalTask.Resources;

import java.time.Instant;

public class RunAway {
    private int id;
    private volatile boolean busy;
    private volatile Instant startTimeDepart;
    private volatile Instant endTimeDepart;

    public RunAway(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public Instant getStartTimeDepart() {
        return startTimeDepart;
    }

    public void setStartTimeDepart(Instant startTimeDepart) {
        this.startTimeDepart = startTimeDepart;
    }

    public Instant getEndTimeDepart() {
        return endTimeDepart;
    }

    public void setEndTimeDepart(Instant endTimeDepart) {
        this.endTimeDepart = endTimeDepart;
    }

    @Override
    public String toString() {
        return "runaway{" +
                "id=" + id +
                '}';
    }
}
