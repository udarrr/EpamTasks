package Enums;

public enum enumModelMitsubishi
{
    SPACESTAR,VAGON,PADJERO,OUTLANDER,ASX,ECLIPSE;

    public static enumModelMitsubishi getRandomModelMitsubishi()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}