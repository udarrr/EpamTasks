package com.company;

import Enums.CarColor;
import Enums.CarVendor;

import java.util.Objects;

public class Car
{
    private int id;
    private CarVendor vendor;
    private String model;
    private int year;
    private CarColor color;
    private double price;
    private String regId;

    public Car()
    {
        super();
    }

    public Car(int id, CarVendor vendor, String model)
    {
        this.id = id;
        this.vendor = vendor;
        this.model = model;
    }

    public Car(int id, CarVendor vendor, String model, int year, CarColor color, double price, String regId)
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

    public CarVendor getVendor()
    {
        return vendor;
    }

    public void setVendor(CarVendor vendor)
    {
        this.vendor = vendor;
    }

    public CarColor getColor()
    {
        return color;
    }

    public void setColor(CarColor color)
    {
        this.color = color;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && year == car.year && Double.compare(car.price, price) == 0 &&
                vendor == car.vendor && Objects.equals(model, car.model) && color == car.color &&
                Objects.equals(regId, car.regId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, vendor, model, year, color, price, regId);
    }

    @Override
    public String toString()
    {
        return " ID='"  + getId() + '\''  + " vendor='" + getVendor() + '\'' +
                " model='" + getModel() + '\'' + " year='" + getYear() + '\'' + " color='" + getColor() + '\'' +
                " price='" + getPrice() + '\'' + " regId='"+ getRegId();
    }
}
