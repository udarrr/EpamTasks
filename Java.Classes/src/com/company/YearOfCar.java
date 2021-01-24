package com.company;

public class YearOfCar extends ModelOfCar
{
    private int year;

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public YearOfCar(int id, String vendor, String model, int year)
    {
        super(id, vendor, model);
        this.year = year;
    }

    @Override
    public String toString()
    {
       return getId() + " " + getVendor() + " " + getModel() + " " + getYear();
    }


}
