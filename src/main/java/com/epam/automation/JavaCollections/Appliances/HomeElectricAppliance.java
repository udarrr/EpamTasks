package com.epam.automation.JavaCollections.Appliances;

import com.opencsv.bean.CsvBindByName;

public class HomeElectricAppliance
{
    @CsvBindByName
    String model;
    @CsvBindByName
    String function;
    @CsvBindByName
    String power;
    @CsvBindByName
    String electricConnectionType;
    @CsvBindByName
    String networkConnection;

    public HomeElectricAppliance()
    {
        super();
    }

    public HomeElectricAppliance(String model, String function, String power, String electricConnectionType, String networkConnection)
    {
        this.model = model;
        this.function = function;
        this.power = power;
        this.electricConnectionType = electricConnectionType;
        this.networkConnection = networkConnection;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getFunction()
    {
        return function;
    }

    public void setFunction(String function)
    {
        this.function = function;
    }

    public String getPower()
    {
        return power;
    }

    public void setPower(String power)
    {
        this.power = power;
    }

    public String getElectricConnectionType()
    {
        return electricConnectionType;
    }

    public void setElectricConnectionType(String electricConnectionType)
    {
        this.electricConnectionType = electricConnectionType;
    }

    public String getNetworkConnection()
    {
        return networkConnection;
    }

    public void setNetworkConnection(String networkConnection)
    {
        this.networkConnection = networkConnection;
    }

    @Override
    public String toString()
    {
        return "HomeElectricAppliance{" +
                ", model='" + model + '\'' +
                ", function='" + function + '\'' +
                ", power='" + power + '\'' +
                ", electricConnectionType='" + electricConnectionType + '\'' +
                ", networkConnection='" + networkConnection + '\'' +
                '}';
    }
}
