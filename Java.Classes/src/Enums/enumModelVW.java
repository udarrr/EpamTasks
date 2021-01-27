package Enums;

public enum enumModelVW
{
    POLO,TOURAN,GOLF,PASSAT,SHARAN;

    public static enumModelVW getRandomModelsVW()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}
