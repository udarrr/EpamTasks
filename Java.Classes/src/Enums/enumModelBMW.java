package Enums;

public enum enumModelBMW
{
    X1,X2,X3,X4,X5,X6,X7;

    public static enumModelBMW getRandomModelBMW()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}
