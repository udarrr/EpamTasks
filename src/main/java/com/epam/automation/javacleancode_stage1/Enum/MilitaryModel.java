package com.epam.automation.javacleancode_stage1.Enum;

public enum MilitaryModel {
    B1B_LANCER("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
    B2_SPIRIT("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
    B52_STRATOFORTRESS("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
    F15("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
    F22("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
    C130_HERCULES("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT);

    private final String model;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;
    private final MilitaryType type;

    MilitaryModel(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
        this.type = type;
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

    public MilitaryType getType() {
        return type;
    }
}
