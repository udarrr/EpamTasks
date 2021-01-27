package Enums;

public enum enumVendorCars
{
    VW,BMW,MITSUBISHI,VAZ;

    public static enumVendorCars getRandomVendorsCars()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}
