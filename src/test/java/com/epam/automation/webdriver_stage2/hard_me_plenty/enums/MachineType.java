package com.epam.automation.webdriver_stage2.hard_me_plenty.enums;

public enum MachineType {
    N1_STANDART_8("CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8","n1-standard-8");

    private final String type;
    private final String description;

    MachineType(String type, String description) {
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
