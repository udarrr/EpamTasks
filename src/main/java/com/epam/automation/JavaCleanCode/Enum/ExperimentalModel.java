package com.epam.automation.JavaCleanCode.Enum;

public enum ExperimentalModel {
    BELL_X14("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationSecurityLevel.SECRET),
    RYAN_X13_VERTIJET("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationSecurityLevel.TOP_SECRET);

    private final String model;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;
    private final ExperimentalType type;
    private final ClassificationSecurityLevel securityLevel;

    ExperimentalModel(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType type, ClassificationSecurityLevel securityLevel) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
        this.type = type;
        this.securityLevel = securityLevel;
    }

    public String getModel() {
        return this.model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public ExperimentalType getType() {
        return type;
    }

    public ClassificationSecurityLevel getSecurityLevel() {
        return securityLevel;
    }
}
