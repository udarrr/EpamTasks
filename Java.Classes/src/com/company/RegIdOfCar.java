package com.company;

public class RegIdOfCar extends PriceOfCar
{
    private String regId;


    public RegIdOfCar(int id, String vendor, String model, int year, String color, Double price, String regId)
    {
        super(id, vendor, model, year, color, price);
        this.regId = regId;
    }

    public RegIdOfCar(int id, String vendor, String model, int year, String color, Double price)
    {
        super(id, vendor, model, year, color, price);
    }

    public String getRegId()
    {
        return regId;
    }

    public void setRegId(String regId)
    {
        this.regId = regId;
    }

    @Override
    public String toString()
    {
        return getId() + " " + getVendor() + " " + getModel() + " " + getYear() + " " + getColor() + " " + getPrice() + " " + getRegId();
    }
}
