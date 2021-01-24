package com.company;

public class ModelOfCar extends VendorOfCar
{
    private String model;

    public ModelOfCar(int id, String vendor, String model)
    {
        super(id, vendor);
        this.model = model;
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
        return getId() + " " + getVendor() + " " + getModel();
    }
}
