package com.company;

public class Car
{
    private int id;
    private String vendor;
    private String model;
    private int year;
    private String  color;
    private double price;
    private  String regId;

    public Car()
    {
        super();
    }

    public Car(int id, String vendor, String model)
    {
        this.id = id;
        this.vendor = vendor;
        this.model = model;
    }

    public Car(int id, String vendor, String model, int year, String color, double price, String regId)
    {
        this(id,vendor,model);
        this.year = year;
        this.color = color;
        this.price = price;
        this.regId = regId;
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
