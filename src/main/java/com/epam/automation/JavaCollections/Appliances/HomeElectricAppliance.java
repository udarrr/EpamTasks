package com.epam.automation.JavaCollections.Appliances;

import com.opencsv.bean.CsvBindByName;

public class HomeElectricAppliance
{
    @CsvBindByName
    String model;
    @CsvBindByName
    String color;
    @CsvBindByName
    String function;
    @CsvBindByName
    int power;
    @CsvBindByName
    String networkConnection;

    public HomeElectricAppliance()
    {
        super();
    }

    public HomeElectricAppliance(String model, String color, String function, int power, String networkConnection)
    {
        this.model = model;
        this.function = function;
        this.power = power;
        this.color = color;
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

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getFunction()
    {
        return function;
    }

    public void setFunction(String function)
    {
        this.function = function;
    }

    public int getPower()
    {
        return power;
    }

    public void setPower(int power)
    {
        this.power = power;
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
        return  "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", function='" + function + '\'' +
                ", power='" + power + " Watt" + '\'' +
                ", networkConnection='" + networkConnection + '\'';
    }
}
