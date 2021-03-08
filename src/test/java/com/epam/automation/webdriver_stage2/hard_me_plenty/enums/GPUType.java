package com.epam.automation.webdriver_stage2.hard_me_plenty.enums;

public enum GPUType {
    NVIDIA_TESLA_V100("NVIDIA_TESLA_V100","NVIDIA Tesla V100");

    private final String type;
    private final String description;

    GPUType(String type, String description) {
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
