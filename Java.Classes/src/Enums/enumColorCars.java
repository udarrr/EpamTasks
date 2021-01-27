package Enums;

public enum enumColorCars
{
    BLACK,WHITE,RED,GREEN,ORANGE,BLUE,BACLAGAN;

    public static enumColorCars getRandomColorOfCars()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}
