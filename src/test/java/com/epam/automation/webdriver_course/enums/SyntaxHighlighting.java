package com.epam.automation.webdriver_course.enums;

public enum SyntaxHighlighting {
    BASH("Bash");

    private final String typeSyntax;

    SyntaxHighlighting(String typeSyntax) {
        this.typeSyntax = typeSyntax;
    }

    public String getTypeSyntax() {
        return typeSyntax;
    }
}
