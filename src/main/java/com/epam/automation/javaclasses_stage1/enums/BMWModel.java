package com.epam.automation.javaclasses_stage1.enums;

public enum BMWModel {
    X1, X2, X3, X4, X5, X6, X7;

    public static BMWModel getRandomModel() {
        return values()[(int) (Math.random() * values().length)];
    }
}