package com.company;

public class CarInfo extends CarVendor
{
    private int year;
    private String color;
    private double price;
    private  String regId;

    public CarInfo()
    {
        super();
    }

    public CarInfo(int id, String vendor, String model, int year, String color, double price, String regId)
    {
        super(id, vendor, model);
        this.year = year;
        this.color = color;
        this.price = price;
        this.regId = regId;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
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
        return " ID='"  + getId() + '\''  + " vendor='" + getVendor() + '\'' +
                " model='" + getModel() + '\'' + " year='" + getYear() + '\'' + " color='" + getColor() + '\'' +
                " price='" + getPrice() + '\'' + " regId='"+ getRegId();
    }
}
