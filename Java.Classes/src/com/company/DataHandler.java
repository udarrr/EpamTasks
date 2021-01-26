package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataHandler
{
    public CarInfo[] getDataFromVendor(CarInfo[] cars, String request, String command)
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

        CarInfo[] result = new CarInfo[length];

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


    public CarInfo[] getDataFromModel(CarInfo[] cars, String request, String command)
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

        CarInfo[] result = new CarInfo[length];

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

    public CarInfo[] getDataFromYear(CarInfo[] cars, int request, String command)
    {
        int length = 0;
        if(command.equals("="))
        {
            for (CarInfo item : cars)
            {
                if (item.getYear() == request) {
                    length++;
                }
            }
        }
        if(command.equals(">"))
        {
            for (CarInfo item : cars)
            {
                if (item.getYear() > request)
                {
                    length++;
                }
            }
        }
        if(command.equals("<"))
        {
            for (CarInfo item : cars)
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

            for (CarInfo item : cars)
            {
                if ((yearNow -item.getYear()) > request)
                {
                    length++;
                }
            }
        }

        CarInfo[] result = new CarInfo[length];

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
                if(command.equals(">"))
                {
                    if (cars[i].getYear() > request)
                    {
                        result[j] = cars[i];
                        j++;
                    }
                }
            }
            if(command.equals("<"))
            {
                if(command.equals("<"))
                {
                    if (cars[i].getYear() < request)
                    {
                        result[j] = cars[i];
                        j++;
                    }
                }
            }
            if(command.equals("%"))
            {
                Calendar calendar = new GregorianCalendar();
                int yearNow = calendar.get(Calendar.YEAR);

                if(command.equals("%"))
                {
                    if ((yearNow -cars[i].getYear()) > request)
                    {
                        result[j] = cars[i];
                        j++;
                    }
                }
            }
        }
        return  result;
    }

    public CarInfo[] getDataFromPrice(CarInfo[] cars, double request, String command)
    {
        int length = 0;
        if(command.equals("="))
        {
            for (CarInfo item : cars)
            {
                if (item.getPrice() == request) {
                    length++;
                }
            }
        }
        if(command.equals(">"))
        {
            for (CarInfo item : cars)
            {
                if (item.getPrice() > request)
                {
                    length++;
                }
            }
        }
        if(command.equals("<"))
        {
            for (CarInfo item : cars)
            {
                if (item.getPrice() < request)
                {
                    length++;
                }
            }
        }

        CarInfo[] result = new CarInfo[length];

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
                for (CarInfo item : cars)
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
                for (CarInfo item : cars)
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

    public CarInfo[] getDataFromColor(CarInfo[] cars, String request, String command)
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
        CarInfo[] result = new CarInfo[length];

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

    public CarInfo[] getDataFromRegId(CarInfo[] cars, String request, String command)
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

        CarInfo[] result = new CarInfo[length];

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
