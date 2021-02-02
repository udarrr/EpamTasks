package com.epam.automation.JavaCollections.Appliances;

import com.opencsv.bean.CsvBindByName;

public class MajorAppliance extends HomeElectricAppliance
{
    @CsvBindByName
    String majorApplianceType;
    @CsvBindByName
    String additionalConnectionType;
    @CsvBindByName
    double size;

    public MajorAppliance()
    {
        super();
    }

    public MajorAppliance(String model, String function, String power, String electricConnectionType, String networkConnection, String majorApplianceType, String additionalConnectionType, double size)
    {
        super(model, function, power, electricConnectionType, networkConnection);
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
        return super.toString() +
                "majorApplianceType='" + majorApplianceType + '\'' +
                ", additionalConnectionType='" + additionalConnectionType + '\'' +
                ", size=" + size +
                '}';
    }
}
