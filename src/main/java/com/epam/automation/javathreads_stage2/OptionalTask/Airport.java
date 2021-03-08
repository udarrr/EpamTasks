package com.epam.automation.javathreads_stage2.OptionalTask;

import com.epam.automation.javathreads_stage2.OptionalTask.Console.Printer;
import com.epam.automation.javathreads_stage2.OptionalTask.Planes.Plane;
import com.epam.automation.javathreads_stage2.OptionalTask.Resources.PlanningResources;
import com.epam.automation.javathreads_stage2.OptionalTask.Resources.RunAway;
import com.epam.automation.javathreads_stage2.OptionalTask.Resources.RunAwayPool;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Airport {
    PlanningResources planningResources = new PlanningResources(5);
    RunAwayPool pool = new RunAwayPool();

    public void start() {
        for (int i = 0; i < planningResources.getAvailableRunaway(); i++) {
            pool.addRunAway(new RunAway(i));
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Plane(i, this)).start();
        }
    }

    public RunAway getResource(Plane plane) {
        try {
            planningResources.getSemaphore().acquire();

            for (RunAway runAway : pool.getResources()) {
                if (!runAway.isBusy()) {
                    runAway.setBusy(true);
                    runAway.setStartTimeDepart(Instant.now());

                    new Printer().printPlaneTookRunAway(plane, runAway);

                    TimeUnit.MILLISECONDS.sleep(500);

                    return runAway;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void releaseResource(Plane plane, RunAway runAway) {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runAway.setBusy(false);
        runAway.setEndTimeDepart(Instant.now());

        new Printer().printFlewUpPlane(plane, runAway);

        planningResources.getSemaphore().release();
    }
}
