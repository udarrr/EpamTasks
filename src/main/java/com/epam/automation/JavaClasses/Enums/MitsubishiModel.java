package com.epam.automation.JavaClasses.Enums;

public enum MitsubishiModel
{
    SPACESTAR,VAGON,PADJERO,OUTLANDER,ASX,ECLIPSE;

    public static MitsubishiModel getRandomModel()
    {
        return values()[(int) (Math.random() * values().length)];
    }
}
