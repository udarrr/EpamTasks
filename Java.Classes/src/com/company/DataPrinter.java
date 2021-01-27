package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataPrinter
{
    public void printVendor(Car[] vendor, String request, String command)
    {
        for (Car item : vendor)
        {
            if(command.equals("="))
            {
                if (item.getVendor().name().equalsIgnoreCase(request))
                {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public void printModel(Car[] vendor, String request, String command)
    {
        for (Car item : vendor)
        {
            if(command.equals("="))
            {
                if (item.getModel().equalsIgnoreCase(request))
                {
                    System.out.println(item.toString());
                }
            }
        }
    }


    public void printYear(Car[] cars, int request,String command)
    {
        if(command.equals("="))
        {
            for (Car item : cars)
            {
                if (item.getYear() == request)
                {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals(">"))
        {
            for (Car item : cars)
            {
                if (item.getYear() > request)
                {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals("<"))
        {
            for (Car item : cars)
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

            for (Car item : cars)
            {
                if ((yearNow - item.getYear()) > request)
                {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public void printColor(Car[] vendor, String request, String command)
    {
        for (Car item : vendor)
        {
            if(command.equals("="))
            {
                if (item.getColor().name().equalsIgnoreCase(request))
                {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public void printPrice(Car[] vendor, double request, String command)
    {
        if(command.equals("="))
        {
            for (Car item : vendor)
            {
                if (item.getPrice() == request)
                {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals(">"))
        {
            for (Car item : vendor)
            {
                if (item.getPrice() > request)
                {
                    System.out.println(item.toString());
                }
            }
        }
        if(command.equals("<"))
        {
            for (Car item : vendor)
            {
                if (item.getPrice() < request)
                {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public void printRegId(Car[] vendor, String request, String command)
    {
        for (Car item : vendor)
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
