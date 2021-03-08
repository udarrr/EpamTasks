package com.epam.automation.javaclasses_stage1.Enums;

public enum MitsubishiModel {
    SPACESTAR, VAGON, PADJERO, OUTLANDER, ASX, ECLIPSE;

    public static MitsubishiModel getRandomModel() {
        return values()[(int) (Math.random() * values().length)];
    }
}
