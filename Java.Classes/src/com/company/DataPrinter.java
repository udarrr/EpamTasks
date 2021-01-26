package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataPrinter
{
    public void printVendor(CarInfo[] vendor, String request, String command)
    {
        for (CarInfo item : vendor)
        {
            if(command.equals("=")) {
                if (item.getVendor().equalsIgnoreCase(request))
                {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public void printModel(CarInfo[] vendor, String request, String command)
    {
        for (CarInfo item : vendor)
        {
            if(command.equals("=")) {
                if (item.getModel().equalsIgnoreCase(request))
                {
                    System.out.println(item.toString());
                }
            }
        }
    }


    public void printYear(CarInfo[] cars, int request,String command)
    {
        if(command.equals("="))
        {
            for (CarInfo item : cars)
            {
                if (item.getYear() == request) {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals(">"))
        {
            for (CarInfo item : cars)
            {
                if (item.getYear() > request)
                {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals("<"))
        {
            for (CarInfo item : cars)
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

            for (CarInfo item : cars)
            {
                if ((yearNow - item.getYear()) > request)
                {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public void printColor(CarInfo[] vendor, String request, String command)
    {
        for (CarInfo item : vendor)
        {
            if(command.equals("=")) {
                if (item.getColor().equalsIgnoreCase(request))
                {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public void printPrice(CarInfo[] vendor, double request, String command)
    {
        if(command.equals("="))
        {
            for (CarInfo item : vendor) {
                if (item.getPrice() == request) {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals(">"))
        {
            for (CarInfo item : vendor) {
                if (item.getPrice() > request) {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals("<"))
        {
            for (CarInfo item : vendor) {
                if (item.getPrice() < request) {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public void printRegId(CarInfo[] vendor, String request, String command)
    {
        for (CarInfo item : vendor)
        {
            if(command.equals("=")) {
                if (item.getRegId().equalsIgnoreCase(request))
                {
                    System.out.println(item.toString());
                }
            }
        }
    }
}
