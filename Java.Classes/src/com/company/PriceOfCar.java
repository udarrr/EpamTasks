package com.company;

public class PriceOfCar extends ColorOfCar
{
    private Double price;

    public PriceOfCar(int id, String vendor, String model, int year, String color, Double price)
    {
        super(id, vendor, model, year, color);
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return getId() + " " + getVendor() + " " + getModel() + " " + getYear() + " " + getColor() + " " + getPrice();
    }
}
