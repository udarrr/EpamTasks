package com.epam.automation.webdriver_stage2.hard_me_plenty.enums;

public enum GPUQuantity {
    ONE("1","1");

    private final String type;
    private final String description;

    GPUQuantity(String type, String description) {
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
