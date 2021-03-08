package com.epam.automation.javaclasses_stage1.cars;

import com.epam.automation.javaclasses_stage1.enums.Color;
import com.epam.automation.javaclasses_stage1.enums.Vendor;

public class Car {
    private int id;
    private Vendor vendor;
    private String model;
    private int year;
    private Color color;
    private double price;
    private String registrationNumber;

    public Car() {
        super();
    }

    public Car(int id, Vendor vendor, String model) {
        this.id = id;
        this.vendor = vendor;
        this.model = model;
    }

    public Car(int id, Vendor vendor, String model, int year, Color color, double price, String registrationNumber) {
        this(id, vendor, model);
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return " ID='" + getId() + '\'' +
                " vendor='" + getVendor() + '\'' +
                " model='" + getModel() + '\'' +
                " year='" + getYear() + '\'' +
                " color='" + getColor() + '\'' +
                " price='" + getPrice() + '\'' +
                " regId='" + getRegistrationNumber();
    }
}
