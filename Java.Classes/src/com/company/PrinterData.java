package com.company;

public class PrinterData
{
    public static void print(RegIdOfCar[] vendor, String request)
    {
        for (RegIdOfCar item : vendor) {
            if (item.getVendor().equalsIgnoreCase(request)) {
                System.out.println(item.toString());
            } else if (item.getModel().equals(request)) {
                System.out.println(item.toString());
            } else if (item.getColor().equalsIgnoreCase(request)) {
                System.out.println(item.toString());
            } else if (item.getRegId().equalsIgnoreCase(request)) {
                System.out.println(item.toString());
            }
        }
    }

    public static void print(RegIdOfCar[] vendor, int request)
    {
        for (RegIdOfCar item : vendor) {
            if (item.getYear() == request) {
                System.out.println(item.toString());
            } else if (item.getPrice() == request) {
                System.out.println(item.toString());
            }

        }
    }

    public static void print(RegIdOfCar[] vendor, double request)
    {
        for (RegIdOfCar item : vendor) {
            if (item.getPrice() == request) {
                System.out.println(item.toString());
            }
        }
    }
}
