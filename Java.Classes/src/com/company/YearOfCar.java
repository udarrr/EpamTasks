package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

    public static void print(RegIdOfCar[] cars, int request,String command)
    {
        if(command.equals("="))
        {
            for (RegIdOfCar item : cars)
            {
                if (item.getYear() == request) {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals(">"))
        {
            for (RegIdOfCar item : cars)
            {
                if (item.getYear() > request)
                {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals("<"))
        {
            for (RegIdOfCar item : cars)
            {
                if (item.getYear() < request)
                {
                    System.out.println(item.toString());
                }
            }
        }

        if(command.equals("%"))
        {
            Calendar calendar = new GregorianCalendar();
            int yearNow = calendar.get(Calendar.YEAR);

            for (RegIdOfCar item : cars)
            {
                if ((yearNow - item.getYear()) > request)
                {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public static int ValueIndexForArrSecondCommand(RegIdOfCar[] cars, int request, String command)
    {
        int length = 0;
        if(command.equals("="))
        {
            for (RegIdOfCar item : cars)
            {
                if (item.getYear() == request) {
                    length++;
                }
            }
        }
        if(command.equals(">"))
        {
            for (RegIdOfCar item : cars)
            {
                if (item.getYear() > request)
                {
                    length++;
                }
            }
        }
        if(command.equals("<"))
        {
            for (RegIdOfCar item : cars)
            {
                if (item.getYear() < request)
                {
                    length++;
                }
            }
        }
        if(command.equals("%"))
        {
            Calendar calendar = new GregorianCalendar();
            int yearNow = calendar.get(Calendar.YEAR);

            for (RegIdOfCar item : cars)
            {
                if ((yearNow -item.getYear()) > request)
                {
                    length++;
                }
            }
        }
        return length;
    }

    public static RegIdOfCar[] DataFromFirstCommand(RegIdOfCar[] cars, int request, String command)
    {
        int valueIndex  = YearOfCar.ValueIndexForArrSecondCommand(cars,request,command);
        RegIdOfCar[] result = new RegIdOfCar[valueIndex];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getYear() == request)
                {
                    result[j] = cars[i];
                    j++;
                }
            }
        }
        return  result;
    }

    @Override
    public String toString()
    {
        return " ID='"  + getId() + '\''  + " vendor='" + getVendor() + '\'' +
                " model='" + getModel() + '\'' + " year='" + getYear() + '\'';
    }


}
