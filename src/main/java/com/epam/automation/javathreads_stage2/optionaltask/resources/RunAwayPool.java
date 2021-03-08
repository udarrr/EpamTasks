package com.epam.automation.javathreads_stage2.optionaltask.resources;

import java.util.ArrayList;
import java.util.List;

public class RunAwayPool {
    private final List<RunAway> resources = new ArrayList<>();

    public void addRunAway(RunAway runAway) {
        resources.add(runAway);
    }

    public List<RunAway> getResources() {
        return resources;
    }
}
