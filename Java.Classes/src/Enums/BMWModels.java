package Enums;

public enum BMWModels
{
    X1,X2,X3,X4,X5,X6,X7;

    public static BMWModels getRandomBMWModels()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}