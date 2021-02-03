package com.epam.automation.JavaCollections.Appliances;

import com.opencsv.bean.CsvBindByName;

public class MajorAppliance extends HomeElectricAppliance
{
    @CsvBindByName
    private String majorApplianceType;
    @CsvBindByName
    private String additionalConnectionType;
    @CsvBindByName
    private double size;

    public MajorAppliance()
    {
        super();
    }

    public MajorAppliance(String model, String color, String function, int power, String networkConnection, String majorApplianceType, String additionalConnectionType, int size)
    {
        super(model,color, function, power, networkConnection);
        this.majorApplianceType = majorApplianceType;
        this.additionalConnectionType = additionalConnectionType;
        this.size = size;
    }

    public String getMajorApplianceType()
    {
        return majorApplianceType;
    }

    public void setMajorApplianceType(String majorApplianceType)
    {
        this.majorApplianceType = majorApplianceType;
    }

    public String getAdditionalConnectionType()
    {
        return additionalConnectionType;
    }

    public void setAdditionalConnectionType(String additionalConnectionType)
    {
        this.additionalConnectionType = additionalConnectionType;
    }

    public double getSize()
    {
        return size;
    }

    public void setSize(double size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return  "Model='" + super.getModel() +
                ", Power='" + super.getPower() + "Watt"+ " " +
                ", MajorApplianceType='" + majorApplianceType + '\'' +
                ", AdditionalConnectionType='" + additionalConnectionType + '\'' +
                ", Size=" + size + "\"";
    }
}
