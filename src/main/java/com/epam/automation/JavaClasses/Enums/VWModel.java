package com.epam.automation.JavaClasses.Enums;

public enum VWModel {

    POLO, TOURAN, GOLF, PASSAT, SHARAN;

    public static VWModel getRandomModels() {

        return values()[(int) (Math.random() * values().length)];
    }
}
