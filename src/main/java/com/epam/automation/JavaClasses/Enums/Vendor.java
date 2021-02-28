package com.epam.automation.JavaClasses.Enums;

public enum Vendor {
    VW, BMW, MITSUBISHI, VAZ;

    public static Vendor getRandomVendor() {
        return values()[(int) (Math.random() * values().length)];
    }
}

