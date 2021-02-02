package com.epam.automation.JavaCollections.Appliances;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class ConsumerElectronic extends HomeElectricAppliance
{
    @CsvBindByName
    String consumerElectronicType;
    @CsvBindByName
    Double sizeBattery;

    public  ConsumerElectronic()
    {
        super();
    }

    public ConsumerElectronic(String model, String function, String power, String electricConnectionType, String networkConnection, String consumerElectronicType, Double sizeBattery)
    {
        super(model, function, power, electricConnectionType, networkConnection);
        this.consumerElectronicType = consumerElectronicType;
        this.sizeBattery = sizeBattery;
    }

    public String getConsumerElectronicType()
    {
        return consumerElectronicType;
    }

    public void setConsumerElectronicType(String consumerElectronicType)
    {
        this.consumerElectronicType = consumerElectronicType;
    }

    public Double getSizeBattery()
    {
        return sizeBattery;
    }

    public void setSizeBattery(Double sizeBattery)
    {
        this.sizeBattery = sizeBattery;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                "consumerElectronicType='" + consumerElectronicType + '\'' +
                ", sizeBattery=" + sizeBattery +
                '}';
    }
}
