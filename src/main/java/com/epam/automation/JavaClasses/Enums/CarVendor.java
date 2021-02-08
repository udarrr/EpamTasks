package com.epam.automation.JavaClasses.Enums;

public enum CarVendor {

    VW, BMW, MITSUBISHI, VAZ;

    public static CarVendor getRandomVendor() {

        return values()[(int) (Math.random() * values().length)];
    }

    public boolean equalsIgnoreCase(String request) {

        return CarVendor.getRandomVendor().name().equals(request);
    }
}

