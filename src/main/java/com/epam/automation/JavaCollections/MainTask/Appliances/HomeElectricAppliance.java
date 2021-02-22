package com.epam.automation.JavaCollections.MainTask.Appliances;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class HomeElectricAppliance {
    @CsvBindByName
    private String model;
    @CsvBindByName
    private String color;
    @CsvBindByName
    private String function;
    @CsvBindByName
    private int power;
    @CsvBindByName
    private String networkConnection;

    public HomeElectricAppliance() {
        super();
    }

    public HomeElectricAppliance(String model, String color, String function, int power, String networkConnection) {
        this.model = model;
        this.function = function;
        this.power = power;
        this.color = color;
        this.networkConnection = networkConnection;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getNetworkConnection() {
        return networkConnection;
    }

    public void setNetworkConnection(String networkConnection) {
        this.networkConnection = networkConnection;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        HomeElectricAppliance appliance = (HomeElectricAppliance) obj;

        return power == appliance.power &&
                Objects.equals(model, appliance.model) &&
                Objects.equals(color, appliance.color) &&
                Objects.equals(function, appliance.function) &&
                Objects.equals(networkConnection, appliance.networkConnection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, function, power, networkConnection);
    }

    @Override
    public String toString() {
        return "Model='" + model + '\'' +
                ", Color='" + color + '\'' +
                ", Function='" + function + '\'' +
                ", Power='" + power + " Watt" + '\'' +
                ", NetworkConnection='" + networkConnection + '\'';
    }
}
