package com.epam.automation.webdriver_course.enums;

public enum BashColorHighlighting {
    KW2("kw2","#c20cb9"),
    RE5("re5","#660033"),
    ST0("st0","#ff0000"),
    BR0("br0","#7a0874");

    private final String name;
    private final String colorCode;

    BashColorHighlighting(String name, String colorCode) {
        this.name = name;
        this.colorCode = colorCode;
    }

    public String getName() {
        return name;
    }

    public String getColorCode() {
        return colorCode;
    }
}
