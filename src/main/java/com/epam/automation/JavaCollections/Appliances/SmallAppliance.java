package com.epam.automation.JavaCollections.Appliances;

import com.opencsv.bean.CsvBindByName;

public class SmallAppliance extends HomeElectricAppliance
{
    @CsvBindByName
    String smallApplianceType;

    public SmallAppliance()
    {
        super();
    }

    public SmallAppliance(String model, String function, String power, String electricConnectionType, String networkConnection, String smallApplianceType)
    {
        super(model, function, power, electricConnectionType, networkConnection);
        this.smallApplianceType = smallApplianceType;
    }

    public String getSmallApplianceType()
    {
        return smallApplianceType;
    }

    public void setSmallApplianceType(String smallApplianceType)
    {
        this.smallApplianceType = smallApplianceType;
    }

    @Override
    public String toString()
    {
        return super.toString()+ "SmallAppliance{" +
                "smallApplianceType='" + smallApplianceType + '\'' +
                '}';
    }
}
