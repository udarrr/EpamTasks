package com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.enums;

public enum LocalSSD {
    X2_375("2","2x375 GiB");

    private final String type;
    private final String description;

    LocalSSD(String type, String description) {
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
