package com.epam.automation.javaclasses_stage1.enums;

public enum Color {
    BLACK, WHITE, RED, GREEN, ORANGE, BLUE, BACLAGAN;

    public static Color getRandomColor() {
        return values()[(int) (Math.random() * values().length)];
    }
}
