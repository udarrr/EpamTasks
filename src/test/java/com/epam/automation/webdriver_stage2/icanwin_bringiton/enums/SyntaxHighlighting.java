package com.epam.automation.webdriver_stage2.icanwin_bringiton.enums;

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
