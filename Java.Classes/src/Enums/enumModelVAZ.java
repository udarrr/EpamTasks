package Enums;

public enum enumModelVAZ
{
    VESTA,GRANTA,LADA2101,LADA2106,LADASedan,CROSS;

    public static enumModelVAZ getRandomModelVAZ()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}