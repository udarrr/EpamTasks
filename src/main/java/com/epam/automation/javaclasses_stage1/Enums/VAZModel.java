package com.epam.automation.javaclasses_stage1.Enums;

public enum VAZModel {
    VESTA, GRANTA, LADA2101, LADA2106, LADASedan, CROSS;

    public static VAZModel getRandomModel() {
        return values()[(int) (Math.random() * values().length)];
    }
}
