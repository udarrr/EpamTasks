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

    public static void print(RegIdOfCar[] vendor, double request, String command)
    {
        if(command.equals("="))
        {
            for (RegIdOfCar item : vendor) {
                if (item.getPrice() == request) {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals(">"))
        {
            for (RegIdOfCar item : vendor) {
                if (item.getPrice() > request) {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals("<"))
        {
            for (RegIdOfCar item : vendor) {
                if (item.getPrice() < request) {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public static int ValueIndexForArrSecondCommand(RegIdOfCar[] cars, Double request, String command)
    {
        int length = 0;
        if(command.equals("="))
        {
            for (RegIdOfCar item : cars)
            {
                if (item.getPrice() == request) {
                    length++;
                }
            }
        }
        if(command.equals(">"))
        {
            for (RegIdOfCar item : cars)
            {
                if (item.getPrice() > request)
                {
                    length++;
                }
            }
        }
        if(command.equals("<"))
        {
            for (RegIdOfCar item : cars)
            {
                if (item.getPrice() < request)
                {
                    length++;
                }
            }
        }
        return length;
    }

    public static RegIdOfCar[] DataFromFirstCommand(RegIdOfCar[] cars, double request, String command)
    {
        int valueIndex  = PriceOfCar.ValueIndexForArrSecondCommand(cars,request,command);
        RegIdOfCar[] result = new RegIdOfCar[valueIndex];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getPrice() == request)
                {
                    result[j] = cars[i];
                    j++;
                }
            }
            if(command.equals(">"))
            {
                for (RegIdOfCar item : cars)
                {
                    if (item.getPrice() > request)
                    {
                        result[j] = cars[i];
                        j++;
                    }
                }
            }
            if(command.equals("<"))
            {
                for (RegIdOfCar item : cars)
                {
                    if (item.getPrice() < request)
                    {
                        result[j] = cars[i];
                        j++;
                    }
                }
            }
        }
        return  result;
    }

    @Override
    public String toString()
    {
        return " ID='"  + getId() + '\''  + " vendor='" + getVendor() + '\'' +
                " model='" + getModel() + '\'' + " year='" + getYear() + '\'' + " color='" + getColor() + '\'' +
                " price='" + getPrice() + '\'';
    }
}
