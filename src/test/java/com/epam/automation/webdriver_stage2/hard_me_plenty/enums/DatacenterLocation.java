package com.epam.automation.webdriver_stage2.hard_me_plenty.enums;

public enum DatacenterLocation {
    FRANKFURT("europe-west3","Frankfurt");

    private final String type;
    private final String description;

    DatacenterLocation(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
