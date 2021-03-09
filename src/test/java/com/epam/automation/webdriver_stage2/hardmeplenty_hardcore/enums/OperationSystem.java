package com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.enums;

public enum OperationSystem {
    FREE("free","Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");

    private final String type;
    private final String description;

    OperationSystem(String type, String description) {
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
