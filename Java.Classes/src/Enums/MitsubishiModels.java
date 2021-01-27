package Enums;

public enum MitsubishiModels
{
    SPACESTAR,VAGON,PADJERO,OUTLANDER,ASX,ECLIPSE;

    public static MitsubishiModels getRandomMitsubishiModel()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}
