package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataHandler
{
    public Car[] getDataFromVendor(Car[] cars, String request, String command)
    {
        int length = 0;

        for (int i = 0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getVendor().equalsIgnoreCase(request))
                {
                    length++;
                }
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getVendor().equalsIgnoreCase(request))
                {
                    result[j] = cars[i];
                    j++;
                }
            }
        }
        return  result;
    }


    public Car[] getDataFromModel(Car[] cars, String request, String command)
    {
        int length = 0;
        for (int i = 0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getModel().equals(request))
                {
                    length++;
                }
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getModel().equalsIgnoreCase(request))
                {
                    result[j] = cars[i];
                    j++;
                }
            }
        }
        return  result;
    }

    public Car[] getDataFromYear(Car[] cars, int request, String command)
    {
        int length = 0;
        if(command.equals("="))
        {
            for (Car item : cars)
            {
                if (item.getYear() == request) {
                    length++;
                }
            }
        }
        if(command.equals(">"))
        {
            for (Car item : cars)
            {
                if (item.getYear() > request)
                {
                    length++;
                }
            }
        }
        if(command.equals("<"))
        {
            for (Car item : cars)
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

            for (Car item : cars)
            {
                if ((yearNow -item.getYear()) > request)
                {
                    length++;
                }
            }
        }

        Car[] result = new Car[length];

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
            if(command.equals(">"))
            {
                if (cars[i].getYear() > request)
                {
                        result[j] = cars[i];
                        j++;
                }
            }
            if(command.equals("<"))
            {

                if (cars[i].getYear() < request)
                {
                        result[j] = cars[i];
                        j++;
                }
            }
            if(command.equals("%"))
            {
                Calendar calendar = new GregorianCalendar();
                int yearNow = calendar.get(Calendar.YEAR);

                if ((yearNow -cars[i].getYear()) > request)
                {
                    result[j] = cars[i];
                    j++;
                }
            }
        }
        return  result;
    }

    public Car[] getDataFromPrice(Car[] cars, double request, String command)
    {
        int length = 0;
        if(command.equals("="))
        {
            for (Car item : cars)
            {
                if (item.getPrice() == request) {
                    length++;
                }
            }
        }
        if(command.equals(">"))
        {
            for (Car item : cars)
            {
                if (item.getPrice() > request)
                {
                    length++;
                }
            }
        }
        if(command.equals("<"))
        {
            for (Car item : cars)
            {
                if (item.getPrice() < request)
                {
                    length++;
                }
            }
        }

        Car[] result = new Car[length];

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
                for (Car item : cars)
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
                for (Car item : cars)
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

    public Car[] getDataFromColor(Car[] cars, String request, String command)
    {
        int length = 0;
        for (int i = 0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getColor().equalsIgnoreCase(request))
                {
                    length++;
                }
            }
        }
        Car[] result = new Car[length];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getColor().equalsIgnoreCase(request))
                {
                    result[j] = cars[i];
                    j++;
                }
            }
        }
        return  result;
    }

    public Car[] getDataFromRegId(Car[] cars, String request, String command)
    {
        int length = 0;
        for (int i = 0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getRegId().equalsIgnoreCase(request))
                {
                    length++;
                }
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getRegId().equalsIgnoreCase(request))
                {
                    result[j] = cars[i];
                    j++;
                }
            }
        }
        return  result;
    }
}
