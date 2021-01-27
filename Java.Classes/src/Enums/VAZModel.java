package Enums;

public enum VAZModel
{
    VESTA,GRANTA,LADA2101,LADA2106,LADASedan,CROSS;

    public static VAZModel getRandomVAZModel()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}
