package Enums;

public enum CarVendors
{
    VW,BMW,MITSUBISHI,VAZ;

    public static CarVendors getRandomCarVendors()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}

