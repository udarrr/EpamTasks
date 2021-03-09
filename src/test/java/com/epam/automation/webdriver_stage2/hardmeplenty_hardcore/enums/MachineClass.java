package com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.enums;

public enum MachineClass {
    REGULAR("regular","Regular");

    private final String type;
    private final String description;

    MachineClass(String type, String description) {
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
