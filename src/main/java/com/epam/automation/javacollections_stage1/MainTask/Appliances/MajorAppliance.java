package com.epam.automation.javacollections_stage1.MainTask.Appliances;

import com.opencsv.bean.CsvBindByName;

public class MajorAppliance extends HomeElectricAppliance {
    @CsvBindByName
    private String majorApplianceType;
    @CsvBindByName
    private String additionalConnectionType;
    @CsvBindByName
    private double height;

    public MajorAppliance() {
        super();
    }

    public MajorAppliance(String model, String color, String function, int power, String networkConnection, String majorApplianceType, String additionalConnectionType, int height) {
        super(model, color, function, power, networkConnection);

        this.majorApplianceType = majorApplianceType;
        this.additionalConnectionType = additionalConnectionType;
        this.height = height;
    }

    public String getMajorApplianceType() {
        return majorApplianceType;
    }

    public void setMajorApplianceType(String majorApplianceType) {
        this.majorApplianceType = majorApplianceType;
    }

    public String getAdditionalConnectionType() {
        return additionalConnectionType;
    }

    public void setAdditionalConnectionType(String additionalConnectionType) {
        this.additionalConnectionType = additionalConnectionType;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Model='" + super.getModel() +
                ", Power='" + super.getPower() + "Watt" + " " +
                ", MajorApplianceType='" + majorApplianceType + '\'' +
                ", AdditionalConnectionType='" + additionalConnectionType + '\'' +
                ", Height=" + height + "\"";
    }
}
