package com.epam.automation.JavaThreads.OptionalTask.Console;

import com.epam.automation.JavaThreads.OptionalTask.Planes.Plane;
import com.epam.automation.JavaThreads.OptionalTask.Resources.RunAway;

import java.time.Duration;

public class Printer {
    public void printFlewUpPlane(Plane plane, RunAway runAway) {
        System.out.println(plane.toString() + " flew up " + runAway.toString() + " time spent: " +
                Duration.between(runAway.getStartTimeDepart(), runAway.getEndTimeDepart()).toSeconds() + " min");
    }

    public void printPlaneTookRunAway(Plane plane, RunAway runAway) {
        System.out.println(plane.toString() + " take " + runAway.toString());
    }

    public void printPlaneMoveTowardsRunAway(){
        System.out.println(toString() + " plane begins to move towards the runways");
    }

    public void printPlaneFlyUp(String plane, RunAway runAway){
        System.out.println(plane.toString() + " is flying up from " + runAway.toString());
    }
}
