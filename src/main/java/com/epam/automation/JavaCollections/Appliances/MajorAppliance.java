package com.epam.automation.JavaCollections.Appliances;

import com.opencsv.bean.CsvBindByName;

public class MajorAppliance extends HomeElectricAppliance
{
    @CsvBindByName
    String majorApplianceType;
    @CsvBindByName
    String additionalConnectionType;
    @CsvBindByName
    int size;

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

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                "majorApplianceType='" + majorApplianceType + '\'' +
                ", additionalConnectionType='" + additionalConnectionType + '\'' +
                ", size=" + size + "\"";
    }
}
