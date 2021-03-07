package com.epam.automation.webdriver_course.enums;

public enum SyntaxHighlighting {
    BASH("Bash");

    private final String type;

    SyntaxHighlighting(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
