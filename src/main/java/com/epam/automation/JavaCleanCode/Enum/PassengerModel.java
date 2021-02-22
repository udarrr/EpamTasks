package com.epam.automation.JavaCleanCode.Enum;

public enum PassengerModel {
    BOEING_737("Boeing-737", 900, 12000, 60500, 164),
    BOEING_737_800("Boeing-737-800", 940, 12300, 63870, 192),
    BOEING_747("Boeing-747", 980, 16100, 70500, 242),
    AIRBUS_A320("Airbus A320", 930, 11800, 65500, 188),
    AIRBUS_A330("Airbus A330", 990, 14800, 80500, 222),
    EMBRAER_190("Embraer 190", 870, 8100, 30800, 64),
    SUKHOISUPERJET_100("Sukhoi Superjet 100", 870, 11500, 50500, 140),
    BOMBARDIER_CS300("Bombardier CS300", 920, 11000, 60700, 196);

    private final String model;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;
    private final int maxPassengerCapacity;

    PassengerModel(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int maxPassengerCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
        this.maxPassengerCapacity = maxPassengerCapacity;
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

    public int getMaxPassengerCapacity() {
        return maxPassengerCapacity;
    }
}
