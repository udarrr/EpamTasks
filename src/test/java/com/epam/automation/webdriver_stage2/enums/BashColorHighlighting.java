package com.epam.automation.webdriver_stage2.enums;

public enum BashColorHighlighting {
    KW2("kw2","#c20cb9"),
    RE5("re5","#660033"),
    ST0("st0","#ff0000"),
    BR0("br0","#7a0874");

    private final String name;
    private final String colorCode;

    BashColorHighlighting(String name, String code) {
        this.name = name;
        this.colorCode = code;
    }

    public String getName() {
        return name;
    }

    public String getColorCode() {
        return colorCode;
    }
}