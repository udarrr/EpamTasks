package com.epam.automation.JavaClasses.Enums;

public enum Color {
    BLACK, WHITE, RED, GREEN, ORANGE, BLUE, BACLAGAN;

    public static Color getRandomColor() {
        return values()[(int) (Math.random() * values().length)];
    }
}
