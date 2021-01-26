package com.company;

public class CarVendor
{
    private int id;
    private String vendor;
    private String model;

    public CarVendor()
    {
        super();
    }

    public CarVendor(int id, String vendor, String model)
    {
        this.id = id;
        this.vendor = vendor;
        this.model = model;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor(String vendor)
    {
        this.vendor = vendor;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }


    @Override
    public String toString()
    {
        return " ID='"  + getId() + '\''  + " vendor='" + getVendor() + '\'' + getModel() + '\'';
    }
}
