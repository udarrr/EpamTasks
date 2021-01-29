package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ConsolePrinter
{
    public void printVendor(Car[] carDataResult, String request, String command)
    {
        for (Car item : carDataResult)
        {
            if (command.equals("=") && item.getVendor().name().equalsIgnoreCase(request))
            {
                System.out.println(item.toString());
            }
        }
    }

    public void printModel(Car[] carDataResult, String request, String command)
    {
        for (Car item : carDataResult)
        {
            if (command.equals("=") && item.getModel().equalsIgnoreCase(request))
            {
                System.out.println(item.toString());
            }
        }
    }

    public void printYear(Car[] carDataResult, int request,String command)
    {
        Calendar calendar = new GregorianCalendar();
        int yearNow = calendar.get(Calendar.YEAR);

        for (Car item : carDataResult)
        {
            if (command.equals("=") && (item.getYear() == request))
            {
                System.out.println(item.toString());
            }
        }

        for (Car item : carDataResult)
        {
            if (command.equals(">") && (item.getYear() > request))
            {
                System.out.println(item.toString());
            }
        }

        for (Car item : carDataResult)
        {
            if (command.equals("<") && (item.getYear() < request))
            {
                System.out.println(item.toString());
            }
        }

        for (Car item : carDataResult)
        {
            if (command.equals("%") && ((yearNow - item.getYear()) > request))
            {
                System.out.println(item.toString());
            }
        }
    }

    public void printColor(Car[] carDataResult, String request, String command)
    {
        for (Car item : carDataResult)
        {
            if (command.equals("=") && item.getColor().name().equalsIgnoreCase(request))
            {
                System.out.println(item.toString());
            }
        }
    }

    public void printPrice(Car[] carDataResult, double request, String command)
    {
        for (Car item : carDataResult)
        {
            if (command.equals("=") && (item.getPrice() == request))
            {
                System.out.println(item.toString());
            }
        }


        for (Car item : carDataResult)
        {
            if (command.equals(">") && (item.getPrice() > request))
            {
                System.out.println(item.toString());
            }
        }


        for (Car item : carDataResult)
        {
            if (command.equals("<") && (item.getPrice() < request))
            {
                System.out.println(item.toString());
            }
        }
    }

    public void printRegId(Car[] carDataResult, String request, String command)
    {
        for (Car item : carDataResult)
        {
            if(command.equals("=") && item.getRegId().equalsIgnoreCase(request))
            {
                System.out.println(item.toString());
            }
        }
    }
}
