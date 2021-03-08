package com.epam.automation.webdriver_stage2.hard_me_plenty.enums;

public enum Series {
    N1("n1","N1");

    private final String type;
    private final String description;

    Series(String type, String description) {
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
