package com.epam.automation.Java.Classes.src.Enums;

public enum VAZModel
{
    VESTA,GRANTA,LADA2101,LADA2106,LADASedan,CROSS;

    public static VAZModel getRandomModel()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}
