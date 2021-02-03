package com.epam.automation.JavaCollections.Appliances;

import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;

public class ConsumerElectronic extends HomeElectricAppliance
{
    @CsvBindByName
    String consumerElectronicType;
    @CsvBindByName
    int batteryCapacity;

    public  ConsumerElectronic()
    {
        super();
    }

    public ConsumerElectronic(String model, String color, String function, int power, String networkConnection, String consumerElectronicType, int batteryCapacity)
    {
        super(model,color, function, power, networkConnection);
        this.consumerElectronicType = consumerElectronicType;
        this.batteryCapacity = batteryCapacity;
    }

    public String getConsumerElectronicType()
    {
        return consumerElectronicType;
    }

    public void setConsumerElectronicType(String consumerElectronicType)
    {
        this.consumerElectronicType = consumerElectronicType;
    }

    public int getBatteryCapacity()
    {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity)
    {
        this.batteryCapacity = batteryCapacity;
    }


    @Override
    public String toString()
    {
        return super.toString() +
                "consumerElectronicType='" + consumerElectronicType + '\'' +
                ", sizeBattery=" + batteryCapacity;
    }
}
