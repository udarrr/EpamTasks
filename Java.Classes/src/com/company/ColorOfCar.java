package com.company;

public class ColorOfCar extends YearOfCar
{
    private String color;

    public ColorOfCar(int id, String vendor, String model,int year, String color)
    {
        super(id, vendor, model, year);
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public String toString()
    {
        return getId() + " " + getVendor() + " " + getModel() + " " + getYear() + " " + getColor();
    }
}
