package com.company;

public class VendorOfCar
{
    private int id;
    private String vendor;

    public VendorOfCar(int id, String vendor)
    {
        this.id = id;
        this.vendor = vendor;
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

    @Override
    public String toString()
    {
        return getId() + " " + getVendor();
    }
}
