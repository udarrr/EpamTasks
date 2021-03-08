package com.epam.automation.webdriver_stage2.hard_me_plenty.enums;

public enum CommittedUsage {
    YEAR_1("1","1 Year");

    private final String type;
    private final String description;

    CommittedUsage(String type, String description) {
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
