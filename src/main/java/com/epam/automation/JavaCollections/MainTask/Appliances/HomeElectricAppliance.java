package com.epam.automation.JavaCollections.MainTask.Appliances;

import com.opencsv.bean.CsvBindByName;

public class HomeElectricAppliance
{
    @CsvBindByName
    private String model;
    @CsvBindByName
    private String color;
    @CsvBindByName
    private String function;
    @CsvBindByName
    private int power;
    @CsvBindByName
    private String networkConnection;

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
    public boolean equals(Object otherAppliance)
    {
        if (this == otherAppliance)
        {
            return true;
        }

        if (!(otherAppliance instanceof HomeElectricAppliance))
        {
            return false;
        }

        HomeElectricAppliance that = (HomeElectricAppliance) otherAppliance;
        return power == that.power && model.equals(that.model) && color.equals(that.color) && function.equals(that.function) && networkConnection.equals(that.networkConnection);
    }

    @Override
    public String toString()
    {
        return  "Model='" + model + '\'' +
                ", Color='" + color + '\'' +
                ", Function='" + function + '\'' +
                ", Power='" + power + " Watt" + '\'' +
                ", NetworkConnection='" + networkConnection + '\'';
    }
}
