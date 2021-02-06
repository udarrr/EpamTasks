package com.epam.automation.JavaCollections.MainTask.Appliances;

import com.opencsv.bean.CsvBindByName;

public class ConsumerElectronic extends HomeElectricAppliance
{
    @CsvBindByName
    private String consumerElectronicType;
    @CsvBindByName
    private int batteryCapacity;

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
        return "Model='" + super.getModel()  +
                ", Power='" + super.getPower() + "Watt"+ " " +
                "ConsumerElectronicType='" + consumerElectronicType + '\'' +
                ", BatteryCapacity=" + batteryCapacity + "Ah";
    }
}
