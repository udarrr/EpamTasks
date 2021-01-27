package Enums;

public enum VWModels
{
    POLO,TOURAN,GOLF,PASSAT,SHARAN;

    public static VWModels getRandomVWModels()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}
