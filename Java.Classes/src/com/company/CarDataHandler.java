package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CarDataHandler
{
    public Car[] getDataFromVendor(Car[] carData, String request, String command)
    {
        int length = 0;

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getVendor().name().equalsIgnoreCase(request))
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getVendor().name().equalsIgnoreCase(request))
            {
                result[j++] = carData[i];
            }
        }

        return  result;
    }

    public Car[] getDataFromModel(Car[] carData, String request, String command)
    {
        int length = 0;

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getModel().equalsIgnoreCase(request))
            {
                length++;
            }
        }


        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getModel().equalsIgnoreCase(request))
            {
                result[j++] = carData[i];
            }
        }

        return  result;
    }

    public Car[] getDataFromYear(Car[] carData, int request, String command)
    {
        int length = 0;


        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getYear() == request)
            {
                length++;
            }
        }
        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals(">") && carData[i].getYear() > request)
            {
                length++;
            }
        }
        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("<") && carData[i].getYear() < request)
            {
                length++;
            }
        }

        Calendar calendar = new GregorianCalendar();
        int yearNow = calendar.get(Calendar.YEAR);

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("%") &&  (yearNow - carData[i].getYear()) > request)
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getYear() == request)
            {
                result[j++] = carData[i];
            }

            if (command.equals(">") && carData[i].getYear() > request)
            {
                result[j++] = carData[i];
            }

            if (command.equals("<") && carData[i].getYear() < request)
            {
                result[j++] = carData[i];
            }

            if (command.equals("%") && (yearNow - carData[i].getYear()) > request)
            {
                result[j++] = carData[i];
            }

        }
        return  result;
    }

    public Car[] getDataFromPrice(Car[] carData, double request, String command)
    {
        int length = 0;

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getPrice() == request)
            {
                length++;
            }
        }
        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals(">") && carData[i].getPrice() > request)
            {
                length++;
            }
        }
        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("<") && carData[i].getPrice() < request)
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getPrice() == request)
            {
                result[j++] = carData[i];
            }

            if (command.equals(">") && carData[i].getPrice() > request)
            {
                result[j++] = carData[i];
            }

            if (command.equals("<") && carData[i].getPrice() < request)
            {
                result[j++] = carData[i];
            }
        }
        return  result;
    }

    public Car[] getDataFromColor(Car[] cars, String request, String command)
    {
        int length = 0;

        for (int i = 0; i < cars.length; i++)
        {
            if (command.equals("=") && cars[i].getColor().name().equalsIgnoreCase(request))
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if (command.equals("=") && cars[i].getColor().name().equalsIgnoreCase(request))
            {
                result[j++] = cars[i];
            }
        }

        return  result;
    }

    public Car[] getDataFromRegId(Car[] carData, String request, String command)
    {
        int length = 0;

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getRegId().equalsIgnoreCase(request))
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getRegId().equalsIgnoreCase(request))
            {
                result[j++] = carData[i];
            }
        }
        return  result;
    }
}
